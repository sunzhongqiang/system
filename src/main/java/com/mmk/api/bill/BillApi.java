package com.mmk.api.bill;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.constants.TuanConstant;
import com.mmk.common.model.ResultData;
import com.mmk.trade.condition.OrderCondition;
import com.mmk.trade.model.Order;
import com.mmk.trade.service.OrderService;

@RestController
public class BillApi {
	
	@Resource
	private OrderService orderService;

	/**
	 * 更改订单状态
	 * @param id 订单id
	 * @return 订单状态更新
	 */
	@RequestMapping("/api/bill/update")
	public Map<String,Object> updateStatus(Long id){
		Map<String, Object> result = new HashMap<String,Object>();
		Order order = orderService.findById(id);
		order.setOrderStatus(0l);
		Order save = orderService.save(order);
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
		Integer wait = orderService.countByOpenid(openid,TuanConstant.TUAN_STATUS_WAIT);
		Integer fait = orderService.countByOpenid(openid,TuanConstant.TUAN_STATUS_FAIL);
		Integer done = orderService.countByOpenid(openid,TuanConstant.TUAN_STATUS_DONE);
		result.addData("wait", wait);
		result.addData("fait", fait);
		result.addData("done", done);
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
		Page<Order> page = orderService.listBy(openid,orderCondition,pageable);
		result.addData("total", page.getTotalElements());
		result.addData("list", page.getContent());
		result.addData("totalPage", page.getTotalPages());
		return result;
	}
}
