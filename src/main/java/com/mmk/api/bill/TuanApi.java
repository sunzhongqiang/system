package com.mmk.api.bill;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.constants.TuanConstant;
import com.mmk.business.model.Goods;
import com.mmk.business.model.GoodsGroup;
import com.mmk.business.model.UserAddress;
import com.mmk.business.model.WxUser;
import com.mmk.business.service.GoodsGroupService;
import com.mmk.business.service.GoodsService;
import com.mmk.business.service.UserAddressService;
import com.mmk.common.model.ResultData;
import com.mmk.common.model.ResultMsg;
import com.mmk.trade.model.Order;
import com.mmk.trade.model.Tuan;
import com.mmk.trade.service.OrderService;
import com.mmk.trade.service.TuanService;

@RestController
public class TuanApi {
	@Resource
	private TuanService tuanService;
	@Resource
	private OrderService orderService;
	@Resource
	private GoodsGroupService groupService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private UserAddressService addressService;

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
		if (tu == null) {
			// 设置团编码
			tuan.setTuanCode(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
			tuan.setTuanStatus(TuanConstant.TUAN_STATUS_WAIT);
		} else {
			// 团订单
			List<Order> orderList = orderService.findAllByTuanCode(tuan.getTuanCode());

			// 成团状态设置
			if (new Date().after(tuan.getTuanEndDate())) {
				tuan.setTuanStatus(TuanConstant.TUAN_STATUS_FAIL);
			} else if (orderList != null && !orderList.isEmpty() && tuan.getPeopleNum() == orderList.size()) {
				tuan.setTuanStatus(TuanConstant.TUAN_STATUS_DONE);
			} else {
				tuan.setTuanStatus(TuanConstant.TUAN_STATUS_WAIT);
			}
			// 设置抽中幸运者
			if (TuanConstant.ONE_YUAN_TUAN.equals(tuan.getOrderSort())
					&& TuanConstant.TUAN_STATUS_DONE.equals(tuan.getTuanStatus())) {
				Order order = orderList.get(random.nextInt(orderList.size() - 1));
				order.setLuckyOrder(TuanConstant.IS_LUCKER);
				orderService.save(order);
			}
		}
		result.put("tuan", tuan);
		return new ResultData(true, "查找成功", result);
	}

	/**
	 * 开团
	 * @param user
	 * @param goods
	 * @return
	 */
	@RequestMapping("/api/tuan/open")
	@ResponseBody
	public ResultData open(WxUser user, GoodsGroup goodsGroup,UserAddress address) {
		GoodsGroup group = groupService.find(goodsGroup.getId());
		Goods goods = group.getGoods();
		//生成团信息
		Tuan tuan = new Tuan();
		tuan.setGroupId(goods.getId());
		tuan.setGoodName(goods.getGoodsName());
		tuan.setGoodImg(goods.getGoodsMainImg());
		tuan.setTuanCode(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		tuan.setTuanStatus(TuanConstant.TUAN_STATUS_WAIT);
		tuan.setOrderSort(goods.getGoodsCat());
		tuan.setPeopleNum(group.getNum());
		tuan.setTuanStartDate(new Date());
		
		Tuan bean = tuanService.save(tuan);
		
		//用户地址
		address = addressService.find(address.getId());
		//生成团订单信息
		Order order = new Order();
		order.setAddress(address.toString());
		order.setColonel(user.getId());
		order.setGoodsCode(goods.getGoodsCode());
		order.setGoodsImg(goods.getGoodsOriginalImg());
		order.setGoodsName(goods.getGoodsName());
		order.setGoodsPrice(goods.getPromotePrice());
		order.setGoodsId(goods.getId());
		order.setOrderCode(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		order.setOrderPhone(address.getMobile());
		order.setOrderPrice(goodsGroup.getGroupPrice());
		order.setOrderSort(goodsGroup.getType());
		order.setOrderStatus(TuanConstant.TUAN_STATUS_WAIT);
		order.setOrderTime(new Date());
		order.setTuanCode(bean.getTuanCode());
		order.setUserId(user.getId());
		order.setUserName(user.getNickname());
		
		order = orderService.save(order);
		
		//开团数量加1
		Long groupNum = group.getGroupNum() == null ? 1l : group.getGroupNum()+1;
		group.setGroupNum(groupNum);
		groupService.save(goodsGroup);
		
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
		tuan.setGoodName(goods.getGoodsName());
		tuan.setGoodImg(goods.getGoodsMainImg());
		tuan.setTuanCode(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		tuan.setTuanStatus(TuanConstant.TUAN_STATUS_WAIT);
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
		Page<Tuan> tuanList = tuanService.findAllByGroupIdAndStatus(groupId,TuanConstant.TUAN_STATUS_WAIT,pageable);
		ResultData result = new ResultData(true, "当前为开团的团但是未成团的团");
		result.addData("groupNum", 10);
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
		List<Order> orderList = orderService.findAllByTuanCode(tuan.getTuanCode());
		ResultData result = new ResultData(true, "正在实现");
		result.addData("tuan", tuan);
		result.addData("orderList", orderList);
		return result;
	}
	
	
	
}
