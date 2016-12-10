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
	 * 用户参团
	 * @param tuanId 团id
	 * @param userId 用户id
	 * @param addressId 地址id
	 * @return 参团结果
	 */
	@RequestMapping("/api/tuan/join")
	@ResponseBody
	public ResultData join(Long tuanId,Long userId,Long addressId) {

		Map<String, Object> result = new HashMap<String, Object>();
		Tuan bean = tuanService.findById(tuanId);
		if(bean==null){
			return new ResultData(false, "团不存在");
		}
		WxUser user = userService.find(userId);
		if(user==null){
			return new ResultData(false, "用户不存在");
		}
		GoodsGroup group = groupService.find(bean.getGroupId());
		if(group==null){
			return new ResultData(false, "团商品不存在");
		}
		Goods goods = group.getGoods();
		if(goods==null){
			return new ResultData(false, "商品不存在");
		}
		// 团订单
		List<TuanOrder> orderList = orderService.findAllByTuanId(tuanId);
		
		if(orderList.size()>=bean.getPeopleNum()){
			return new ResultData(false, "已经超过成团人数");
		}
		
		
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
		order.setUser(user);
		order.setUserName(user.getNickname());
		order.setHeadimgurl(user.getHeadimgurl());
		order = orderService.save(order);

		// 成团状态设置
		if (bean.getPeopleNum() == orderList.size()) {
			bean.setTuanStatus(TuanStatus.SUCCESSED.name());
			tuanService.save(bean);
		} 
		
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
//		tuan.setTuanStatus(TuanStatus.WAIT_JOIN.name());
		tuan.setTuanStatus(TuanOrderStatus.WAIT_PAY.name());
		tuan.setOrderSort(group.getType());
		tuan.setPeopleNum(group.getNum());
		tuan.setTuanStartDate(new Date());
		tuan.setCommander(user);
		tuan.setJoinNum(1l);
		tuan.setGoodsPrice(group.getGroupPrice());
		tuan.setTuanEndDate(new Date(tuan.getTuanStartDate().getTime()+ group.getDuration()* 24 * 60 * 60 * 1000));
		
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
		order.setUser(user);
		order.setUserName(user.getNickname());
		order.setHeadimgurl(user.getHeadimgurl());
		order = orderService.save(order);
		
		//开团数量加1
		Long groupNum = group.getGroupNum() == null ? 1l : group.getGroupNum()+1;
		group.setGroupNum(groupNum);
		groupService.save(group);
		
		ResultData result = new ResultData(true, "开团完成");
		result.addData("tuan", bean);
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
		List<TuanOrder> orderList = orderService.findAllByTuanId(tuan.getId());
		ResultData result = new ResultData(true, "团详情");
		result.addData("tuan", tuan);
		result.addData("orderList", orderList);
		return result;
	}
	
	
	
}
