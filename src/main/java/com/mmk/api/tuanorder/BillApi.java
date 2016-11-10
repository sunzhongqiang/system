package com.mmk.api.tuanorder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.trade.model.Order;
import com.mmk.trade.service.OrderService;

@RestController
public class BillApi {
	
//	@Resource 
//	private InsureCompanyService companyService;
//	@Resource
//	private CarService carService;
//	@Resource
//	private OrderGoodsService orderGoodsService;
//	@Resource
//	private GoodsService goodsService;
//	@Resource
//	private GoodsAttrService goodsAttrService;
	@Resource
	private OrderService orderService;
//	
//	@Resource
//	private UsersService userService;
//	@Resource
//	private UserAddressService userAddressService;
//	
//	
//	
//	
//	@RequestMapping("/api/bill/build")
//	public Map<String,Object> buildBill(String openid,Long carid,Long insureid,Long[] goodsid,Long[] attrid){
//		Map<String, Object> result = new HashMap<String,Object>();
// 		OrderInfo info = new OrderInfo();
//		info.setOrderSn(DateTime.now().toString("yyyyMMddHHmmssSSS"));
//		info.setOpenid(openid);
//		info.setCarid(carid);
//		
//		Users user = userService.findByUserName(openid);
//		
//		info.setUser(user);
//		info.setOrderStatus(0);
//		info.setPayStatus(0);
//		info.setShippingStatus(0);
//		
//		Car car = carService.find(carid);
//		if(car ==null){
//			result.put("success", false);
//			result.put("msg", "未找到车辆");
//			return result;
//		}
//		info.setCarNumber(car.getCarNumber());
//		info.setInsureid(insureid);
//		InsureCompany insureCompany = companyService.find(insureid);
//		info.setInsureName(insureCompany.getName());
//		info.setInsureLogo(insureCompany.getLogo());
//		info.setAddTime(DateConversionTool.date2long4Db(new Date()));
//		info.setGoodsAmount(0.0);
//		info.setOrderAmount(0.0);
//		info.setShippingFee(0.0);
//		info.setShippingFee(0.0);
//		OrderInfo orderInfo = orderInfoService.save(info);
//		List<OrderGoods> goodsList = orderInfo.getGoodsList();
//		if(goodsList==null){
//			goodsList = new ArrayList<OrderGoods>();
//		}
//		
//		//强险
//		Goods goods1 = goodsService.findOne(13l);
//		OrderGoods orderGoods1 = new OrderGoods();
//		orderGoods1.setGoods(goods1);
//		orderGoods1.setGoodsName(goods1.getGoodsName());
//		orderGoods1.setOrderInfo(orderInfo);
//		orderGoodsService.save(orderGoods1);
//		goodsList.add(orderGoods1 );
//		
//		//车船税
//		Goods goods2 = goodsService.findOne(23l);
//		OrderGoods orderGoods2 = new OrderGoods();
//		orderGoods2.setGoods(goods2);
//		orderGoods2.setGoodsName(goods2.getGoodsName());
//		orderGoods2.setOrderInfo(orderInfo);
//		orderGoodsService.save(orderGoods2);
//		goodsList.add(orderGoods2 );
//		
//		
//		
//		if(goodsid!=null){
//			for (Long gid : goodsid) {
//				OrderGoods orderGoods = new OrderGoods();
//				Goods goods = goodsService.findOne(gid);
//				orderGoods.setGoods(goods);
//				orderGoods.setGoodsName(goods.getGoodsName());
//				orderGoods.setOrderInfo(orderInfo);
//				
//				orderGoodsService.save(orderGoods);
//				
//				goodsList.add(orderGoods);
//			}
//		}
//		if(attrid!=null){
//			for (Long atid : attrid) {
//				GoodsAttr attr = goodsAttrService.find(atid);
//				
//				OrderGoods orderGoods = new OrderGoods();
//				Goods goods = goodsService.findOne(attr.getGoodsId());
//				orderGoods.setGoods(goods);
//				orderGoods.setGoodsName(goods.getGoodsName());
//				orderGoods.setOrderInfo(orderInfo);
//				orderGoods.setGoodsAttr(attr.getAttrValue());
//				orderGoods.setGoodsAttrId(String.valueOf(attr.getAttrId()));
//				orderGoodsService.save(orderGoods);
//				
//				goodsList.add(orderGoods);
//			}
//		}
//		
//		result.put("success", true);
//		result.put("msg", "订单生成成功");
//		Map<String,Object> bill = new HashMap<String,Object>();
//		bill.put("billid", orderInfo.getOrderId());
//		bill.put("billno", orderInfo.getOrderSn());
//		result.put("bill", bill);
//		return result ;
//	}
//	
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
//	
//	@RequestMapping("/api/bill/submitData")
//	public Map<String,Object> submitData(Long id,String idPhoto1,String idPhoto2,UserAddress address){
//		Map<String, Object> result = new HashMap<String,Object>();
//		OrderInfo orderInfo = orderInfoService.find(id);
//		long carid = orderInfo.getCarid();
//		Car car = carService.find(carid);
//		car.setIdPhoto1(idPhoto1);
//		car.setIdPhoto2(idPhoto2);
//		carService.save(car);
//		result.put("success", true);
//		result.put("msg", "资料提交成功");
//		
//		if(address.getAddressId()==null){
//			address.setOpenid(car.getOpenid());
//			userAddressService.save(address);
//		}else{
//			address = userAddressService.find(address.getAddressId());
//		}
//		orderInfo.setConsignee(address.getConsignee());
//		orderInfo.setAddress(address.getAddress());
//		orderInfo.setCity(address.getCity());
//		orderInfo.setDistrict(address.getDistrict());
//		orderInfo.setProvince(address.getProvince());
//		orderInfo.setMobile(address.getMobile());
//		
//		orderInfoService.save(orderInfo);
//		
//		return result ;
//	}
//	
	
	
	
	
	

}
