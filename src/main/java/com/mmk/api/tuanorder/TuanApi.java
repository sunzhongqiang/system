package com.mmk.api.tuanorder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmk.common.model.ResultMsg;
import com.mmk.trade.model.Order;
import com.mmk.trade.model.Tuan;
import com.mmk.trade.service.impl.OrderServiceImpl;
import com.mmk.trade.service.impl.TuanServiceImpl;

public class TuanApi {
	@Resource
	private TuanServiceImpl tuanService;
	@Resource
	private OrderServiceImpl orderService;
	
	private String staus_0 = new String("0");
	private String staus_1 = new String("1");
	private String staus_2 = new String("2");
	private String staus_3 = new String("3");
	
	/**
	 * 广告位商品
	 * @return
	 * @date 2016年1月27日 下午2:47:43
	 * @author zq
	 */
	@RequestMapping("/api/tuan/tuanIndex")
	@ResponseBody
	public ResultMsg tuanIndex(Long id){
		Random random = new Random();
		Map<String, Object> result = new HashMap<String,Object>();
		
		// 查询团和团订单
		Tuan tuan = tuanService.findById(id);
		List<Order> orderList = orderService.findAllByTuanCode(tuan.getTuanCode());

		// 成团状态设置
		if(new Date().after(tuan.getTuanEndDate())){
				tuan.setTuanStatus(Long.valueOf(staus_3));
		}else if(orderList != null && !orderList.isEmpty() && tuan.getPeopleNum() == orderList.size()){
				tuan.setTuanStatus(Long.valueOf(staus_2));
		}else {
			tuan.setTuanStatus(Long.valueOf(staus_1));
		}
		
		// 设置团编码
		tuan.setTuanCode(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		
		// 设置抽中幸运者
		if(staus_0.equals(tuan.getOrderSort()) && staus_2.equals(tuan.getTuanStatus())){
			Order order = orderList.get(random.nextInt(orderList.size() - 1));
			order.setLuckyOrder(Long.valueOf(staus_1));
			orderService.save(order);
		}
		result.put("tuan", tuan);
		return new ResultMsg(true, "查找成功", result);
	}	
	

}
