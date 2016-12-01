package com.mmk.api.bill;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.core.Ordered;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.condition.GroupType;
import com.mmk.business.model.Goods;
import com.mmk.business.model.GoodsGroup;
import com.mmk.business.model.UserAddress;
import com.mmk.business.model.WxUser;
import com.mmk.business.service.GoodsGroupService;
import com.mmk.business.service.GoodsService;
import com.mmk.business.service.UserAddressService;
import com.mmk.business.service.WxUserService;
import com.mmk.common.model.ResultData;
import com.mmk.common.model.ResultMsg;
import com.mmk.trade.condition.TuanOrderStatus;
import com.mmk.trade.condition.TuanStatus;
import com.mmk.trade.model.Tuan;
import com.mmk.trade.model.TuanOrder;
import com.mmk.trade.service.TuanOrderService;
import com.mmk.trade.service.TuanService;

@RestController
public class TuanApi {
	@Resource
	private TuanService tuanService;
	@Resource
	private TuanOrderService orderService;
	@Resource
	private GoodsGroupService groupService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private UserAddressService addressService;
	@Resource
	private WxUserService userService;

	/**
	 * 团管理
	 * 
	 * @return
	 * @date 2016年11月8日 下午2:47:43
	 * @author hu
	 */
	@RequestMapping("/api/tuan/tuanIndex")
	@ResponseBody
	public ResultMsg tuanIndex(Long id) {
		Map<String, Object> result = new HashMap<String, Object>();

		// 查询团和团订单
		Tuan tuan = tuanService.findById(id);
		result.put("tuan", tuan);
		return new ResultMsg(true, "查找成功", result);
	}

	/**
	 * 团订单
	 * 
	 * @return
	 * @date 2016年11月8日 下午2:47:43
	 * @author hu
	 */
	@RequestMapping("/api/tuan/join")
	@ResponseBody
	public ResultData join(Tuan tuan,WxUser user,UserAddress address) {

		Random random = new Random();
		Map<String, Object> result = new HashMap<String, Object>();
		Tuan tu = tuanService.findById(tuan.getId());
		// 团订单
		List<TuanOrder> orderList = orderService.findAllByTuanCode(tuan.getTuanCode());

		// 成团状态设置
		if (new Date().after(tuan.getTuanEndDate())) {
//			tuan.setTuanStatus(TuanConstant.TUAN_STATUS_FAIL);
		} else if (orderList != null && !orderList.isEmpty() && tuan.getPeopleNum() == orderList.size()) {
			tuan.setTuanStatus(TuanStatus.SUCCESSED.name());
		} else {
			tuan.setTuanStatus(TuanStatus.WAIT_JOIN.name());
		}
		// 设置抽中幸运者
		if (GroupType.ONE_YUAN_TUAN.equals(tuan.getOrderSort())
				&& TuanStatus.SUCCESSED.name().equals(tuan.getTuanStatus())) {
			TuanOrder order = orderList.get(random.nextInt(orderList.size() - 1));
			order.setLuckyOrder(order.getId());
			orderService.save(order);
		}
		tuan.setJoinNum(tuan.getJoinNum()+1);
		tuan = tuanService.save(tuan);
		result.put("tuan", tuan);
		return new ResultData(true, "查找成功", result);
	}

	/**
	 * 开团
	 * @param userId 用户id
	 * @param groupId 团Id
	 * @param addressId 地址ID
	 * @return
	 */
	@RequestMapping("/api/tuan/open")
	@ResponseBody
	public ResultData open(Long userId, Long groupId,Long addressId) {
		GoodsGroup group = groupService.find(groupId);
		Goods goods = group.getGoods();
		WxUser user = userService.find(userId);
		//生成团信息
		Tuan tuan = new Tuan();
		tuan.setGroupId(goods.getId());
		tuan.setGoodsName(goods.getGoodsName());
		tuan.setGoodsImg(goods.getGoodsMainImg());
		tuan.setTuanCode(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		tuan.setTuanStatus(TuanStatus.WAIT_JOIN.name());
		tuan.setOrderSort(goods.getGoodsCat());
		tuan.setPeopleNum(group.getNum());
		tuan.setTuanStartDate(new Date());
		tuan.setCommander(user);
		tuan.setJoinNum(1l);
		
		Tuan bean = tuanService.save(tuan);
		
		//用户地址
		UserAddress address = addressService.find(addressId);
		//生成团订单信息
		TuanOrder order = new TuanOrder();
		order.setAddress(address.toString());
		order.setColonel(user.getId());
		order.setGoodsCode(goods.getGoodsCode());
		order.setGoodsImg(goods.getGoodsOriginalImg());
		order.setGoodsName(goods.getGoodsName());
		order.setGoodsPrice(goods.getPromotePrice());
		order.setGoodsId(goods.getId());
		order.setOrderCode(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		order.setOrderPhone(address.getMobile());
		order.setOrderPrice(group.getGroupPrice());
		order.setOrderSort(group.getType());
		order.setOrderStatus(TuanOrderStatus.WAIT_JOIN.name());
		order.setOrderTime(new Date());
		order.setTuanId(bean.getId());
		order.setTuanCode(bean.getTuanCode());
		order.setUserId(user.getId());
		order.setUserName(user.getNickname());
		
		order = orderService.save(order);
		
		//开团数量加1
		Long groupNum = group.getGroupNum() == null ? 1l : group.getGroupNum()+1;
		group.setGroupNum(groupNum);
		groupService.save(group);
		
		ResultData result = new ResultData(true, "完成");
		return result;
	}

	

	/**
	 * 构建团订单
	 * @param user 用户信息
	 * @param groupId 团订单编号
	 * @return
	 */
	@RequestMapping("/api/tuan/build")
	@ResponseBody
	public ResultData build(WxUser user, Long groupId) {
		GoodsGroup group = groupService.find(groupId);
		Goods goods = group.getGoods();
		Tuan tuan = new Tuan();
		tuan.setGroupId(goods.getId());
		tuan.setGoodsName(goods.getGoodsName());
		tuan.setGoodsImg(goods.getGoodsMainImg());
		tuan.setTuanCode(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		tuan.setTuanStatus(TuanStatus.WAIT_JOIN.name());
		tuan.setOrderSort(goods.getGoodsCat());
		tuan.setPeopleNum(group.getNum());
		tuan.setTuanStartDate(new Date());
		ResultData result = new ResultData(false, "正在实现");
		return result;
	}
	
	
	/**
	 * 获取当前团商品的参团未成团的团 
	 * @param groupId 团商品
	 * @param pageable 分页
	 * @return 返回该团商品的未成团的团
	 */
	@RequestMapping("/api/tuan/listByGroup")
	@ResponseBody
	public ResultData list(Long groupId,Pageable pageable) {
		Page<Tuan> tuanList = tuanService.findAllByGroupIdAndStatus(groupId,TuanStatus.WAIT_JOIN.name(),pageable);
		ResultData result = new ResultData(true, "当前为开团的团但是未成团的团");
		result.addData("tuanList", tuanList);
		return result;
	}
	
	/**
	 * 团详情
	 * @param id 团详情id
	 * @return 获得的团详情
	 */
	@RequestMapping("/api/tuan/info")
	@ResponseBody
	public ResultData info(Long id) {
		Tuan tuan = tuanService.find(id);
		List<TuanOrder> orderList = orderService.findAllByTuanCode(tuan.getTuanCode());
		ResultData result = new ResultData(true, "团详情");
		result.addData("tuan", tuan);
		result.addData("commender", tuan.getCommander());
		result.addData("orderList", orderList);
		return result;
	}
	
	
	
}
