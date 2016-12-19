package com.mmk.api.bill;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.model.Goods;
import com.mmk.business.model.GoodsGroup;
import com.mmk.business.model.WxUser;
import com.mmk.business.service.GoodsGroupService;
import com.mmk.business.service.WxUserService;
import com.mmk.common.model.ResultData;
import com.mmk.trade.condition.OrderCondition;
import com.mmk.trade.condition.TuanOrderStatus;
import com.mmk.trade.model.Tuan;
import com.mmk.trade.model.TuanOrder;
import com.mmk.trade.service.TuanOrderService;
import com.mmk.trade.service.TuanService;

@RestController
public class BillApi {
	
	@Resource
	private TuanOrderService orderService;
	@Resource
	private GoodsGroupService groupService;
	@Resource
	private TuanService tuanService;
	@Resource
	private WxUserService userService;

	/**
	 * 更改订单状态
	 * @param id 订单id
	 * @return 订单状态更新
	 */
	@RequestMapping("/api/bill/update")
	public Map<String,Object> updateStatus(Long id){
		Map<String, Object> result = new HashMap<String,Object>();
		TuanOrder order = orderService.findById(id);
		order.setOrderStatus(TuanOrderStatus.WAIT_JOIN.name());
		TuanOrder save = orderService.save(order);
		result.put("success", true);
		result.put("msg", "订单生成成功");
		result.put("order", save);
		return result ;
	}
	
	/**
	 * 用户订单统计
	 * @param openid 用户的openid
	 * @return 订单数量
	 */
	@RequestMapping("/api/bill/count")
	@ResponseBody
	public ResultData count(String openid) {
		ResultData result = new ResultData(true, "用户订单统计");
		Integer wait = orderService.countByOpenid(openid,TuanOrderStatus.WAIT_JOIN.name());
		Integer close = orderService.countByOpenid(openid,TuanOrderStatus.CLOSED.name());
		Integer successed = orderService.countByOpenid(openid,TuanOrderStatus.SUCCESSED.name());
		Integer comment = orderService.countByOpenid(openid,TuanOrderStatus.WAIT_COMMENT.name());
		Integer shipping = orderService.countByOpenid(openid,TuanOrderStatus.WAIT_SHIPPING.name());
		Integer received = orderService.countByOpenid(openid,TuanOrderStatus.WAIT_RECEIVE.name());
		Integer refundGoods = orderService.countByOpenid(openid,TuanOrderStatus.WAIT_REFUND_GOODS.name());
		Integer refundMoney = orderService.countByOpenid(openid,TuanOrderStatus.WAIT_REFUND_MONEY.name());
		result.addData(TuanOrderStatus.WAIT_JOIN.name(), wait);
		result.addData(TuanOrderStatus.CLOSED.name(), close);
		result.addData(TuanOrderStatus.SUCCESSED.name(), successed);
		result.addData(TuanOrderStatus.WAIT_COMMENT.name(), comment);
		result.addData(TuanOrderStatus.WAIT_SHIPPING.name(), shipping);
		result.addData(TuanOrderStatus.WAIT_RECEIVE.name(), received);
		result.addData("refund", refundGoods+refundMoney);
		return result;
	}
	
	/**
	 * 用户订单列表
	 * @param openid 用户openid
	 * @param status 订单状态
	 * @return 订单列表
	 */
	@RequestMapping("/api/bill/list")
	@ResponseBody
	public ResultData count(String openid,OrderCondition orderCondition,Pageable pageable) {
		ResultData result = new ResultData(true, "用户订单列表");
		Page<TuanOrder> page = orderService.listBy(openid,orderCondition,pageable);
		result.addData("total", page.getTotalElements());
		result.addData("list", page.getContent());
		result.addData("totalPage", page.getTotalPages());
		return result;
	}
	
	/**
	 * 用户订单列表
	 * @param openid 用户openid
	 * @param tuanStatus 团订单状态
	 * @return 订单列表
	 */
	@RequestMapping("/api/bill/findTuanOrder")
	@ResponseBody
	public ResultData findTuanOrder(String openid, String tuanStatus) {
		ResultData result = new ResultData(true, "用户订单列表");
		List<TuanOrder> tuanOrderList = orderService.findTuanOrder(openid, tuanStatus);
		result.addData("tuanOrderList", tuanOrderList);
		return result;
	}
	
	/**
	 * 订单详情列表
	 * @param openid 用户openid
	 * @param id 订单详情
	 * @return 订单详情
	 */
	@RequestMapping("/api/bill/info")
	@ResponseBody
	public ResultData info(String openid,Long id) {
		ResultData result = new ResultData(true, "用户订单详情");
		TuanOrder order = orderService.find(id);
		if(order!=null){
			WxUser user = order.getUser();
			if(openid.equals(user.getOpenid())){
				Tuan tuan = tuanService.findByCode(order.getTuanCode());
				GoodsGroup group = groupService.find(tuan.getGroupId());
				result.addData("order", order);
				result.addData("tuan", tuan);
				result.addData("group", group);
				result.addData("user", user);
				result.addData("order", order);
			}else{
				return new ResultData(false,"非该用户订单");
			}
		}else{
			return new ResultData(false,"未找到用户订单");
		}
		return result;
	}
	
	/**
	 * 用户订单取消
	 * @param openid 用户openid
	 * @param id 订单id
	 * @return 操作结果
	 */
	@RequestMapping("/api/bill/cancle")
	@ResponseBody
	public ResultData cancle(String openid,Long id){
		ResultData result = new ResultData(true, "用户订单取消成功");
		TuanOrder order = orderService.find(id);
		WxUser user = order.getUser();
		if(openid.equals(user.getOpenid())){
			Tuan tuan = tuanService.find(order.getTuan().getId());
			order.setOrderStatus(TuanOrderStatus.CLOSED.name());
			tuan.setJoinNum(tuan.getJoinNum()-1);
			
			orderService.save(order);
			tuanService.save(tuan);
		}else{
			return new ResultData(false,"非该用户订单");
		}
		return result;
	}
}
