package com.mmk.api.bill;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.trade.model.Order;
import com.mmk.trade.service.OrderService;

@RestController
public class BillApi {
	
	@Resource
	private OrderService orderService;

	/**
	 * 更改订单状态
	 * @param id 订单id
	 * @return
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
}
