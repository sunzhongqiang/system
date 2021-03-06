package com.mmk.api.bill;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
import com.mmk.weixin.service.MessageTemplateService;

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
	
	@Resource
	private MessageTemplateService templateService;

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
		addressService.copyAddress(order, address);
		order.setColonel(user.getId());
		order.setGoodsCode(goods.getGoodsCode());
		order.setGoodsImg(goods.getGoodsOriginalImg());
		order.setGoodsName(goods.getGoodsName());
		order.setGoodsPrice(goods.getPromotePrice());
		order.setGoodsId(goods.getId());
		order.setOrderCode("PIN"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		order.setOrderPhone(address.getMobile());
		order.setOrderPrice(group.getGroupPrice());
		order.setOrderSort(group.getType());
		order.setOrderStatus(TuanOrderStatus.WAIT_PAY.name());
		order.setOrderTime(new Date());
		order.setTuan(bean);
		order.setTuanCode(bean.getTuanCode());
		order.setUser(user);
		order.setUserName(user.getNickname());
		order.setHeadimgurl(user.getHeadimgurl());
		order.setGoodsImg(goods.getGoodsMainImg());
		order = orderService.save(order);
		

		tuanService.save(bean);
		ResultData result = new ResultData(true, "查找成功完成");
		result.addData("tuan", bean);
		result.addData("order", order);
		
		return result;
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
//		tuan.setGroupId(goods.getId());
		tuan.setGroupId(groupId);
		tuan.setGoodsName(goods.getGoodsName());
		tuan.setGoodsImg(goods.getGoodsMainImg());
		tuan.setTuanCode(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		tuan.setOrderSort(group.getType());
		tuan.setPeopleNum(group.getNum());
		tuan.setCommander(user);
		tuan.setJoinNum(0l);
		tuan.setGoodsPrice(group.getGroupPrice());
		tuan.setTuanStartDate(new Date());
		tuan.setTuanEndDate(new Date(tuan.getTuanStartDate().getTime()+ group.getDuration()* 24 * 60 * 60 * 1000));
		tuan.setTuanStatus(TuanStatus.WAIT_PAY.name());
		
		Tuan bean = tuanService.save(tuan);
		
		//用户地址
		UserAddress address = addressService.find(addressId);
		//生成团订单信息
		TuanOrder order = new TuanOrder();
		order = addressService.copyAddress(order,address);
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
		order.setOrderStatus(TuanOrderStatus.WAIT_PAY.name());
		order.setGoodsImg(goods.getGoodsMainImg());
		
		order.setOrderTime(new Date());
		order.setTuan(bean);
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
		result.addData("order", order);
		return result;
	}

	/**
	 * 待成团
	 * @param id 团订单id
	 * @return tuanOrder
	 */
	@RequestMapping("/api/tuan/waitjoin")
	@ResponseBody
	public ResultData orderStatusToWaitJoin(String orderCode,String orderPayCode) {
		TuanOrder tuanOrder = orderService.findByOrderCode(orderCode);
		tuanOrder.setOrderPayCode(orderPayCode);
		tuanOrder.setOrderStatus(TuanOrderStatus.WAIT_JOIN.name());
		tuanOrder.setPayTime(new Date());
		Tuan tuan = tuanService.findById(tuanOrder.getTuan().getId());
		tuan.setTuanStatus(TuanStatus.WAIT_JOIN.name());
		tuan.setJoinNum(tuan.getJoinNum() + 1l);
		orderService.save(tuanOrder);
		tuanService.save(tuan);
		
		
		
		
		
		
		// 成团状态设置
		if (tuan.getPeopleNum() == tuan.getJoinNum()) {
			// 一元拼团的订单挑选本团的幸运者
			if(tuan.getOrderSort()==0l){
				orderService.chooseLuckerByTuanId(tuan.getId());
			}//抽奖团，将用户移交到待抽奖状态
			else if(tuan.getOrderSort()==2l){
				orderService.changeTuanStatusByTuanId(tuan.getId(),TuanOrderStatus.WAIT_CHOOSE.name());
			}//拼团的团将团订单改变为收货状态
			else {
				orderService.changeTuanStatusByTuanId(tuan.getId(),TuanOrderStatus.WAIT_SHIPPING.name());
			}
			tuan.setTuanStatus(TuanStatus.SUCCESSED.name());
			tuanService.save(tuan);
		}else{
			if(TuanStatus.WAIT_PAY.name().equals(tuan.getTuanStatus())){
				tuan.setTuanStatus(TuanStatus.WAIT_JOIN.name());
			}
		}
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("openid", tuanOrder.getUser().getOpenid());
		data.put("first", tuan.getGoodsName());
		data.put("leadername", tuan.getCommander().getNickname());
		data.put("number", tuan.getPeopleNum() - tuan.getJoinNum());
		data.put("remark", "参团成功");
		templateService.sendMessage("", data );
		
		
		ResultData result = new ResultData(true, "团订单已修改成待成团或待发货状态！");
		result.addData("tuan", tuan);
		result.addData("tuanOrder", tuanOrder);
		return result;
	}
	
	/**
	 * 代发货
	 * @param id 团订单id
	 * @return tuanOrder tuan
	 */
	@RequestMapping("/api/tuan/waitreceive")
	@ResponseBody
	public ResultData orderStatusTowaitReceive(Long id) {
		TuanOrder tuanOrder = orderService.findById(id);
		tuanOrder.setOrderStatus(TuanOrderStatus.WAIT_RECEIVE.name());
		orderService.save(tuanOrder);
		Tuan tuan = tuanService.findById(tuanOrder.getTuan().getId());
		tuan.setTuanStatus(TuanStatus.SUCCESSED.name());
		tuanService.save(tuan);
		
		ResultData result = new ResultData(true, "团订单已修改成待发货状态！");
		result.addData("tuanOrder", tuanOrder);
		result.addData("tuan", tuan);
		return result;
	}
	
	/**
	 * 代评价
	 * @param id 团订单id
	 * @return tuanOrder
	 */
	@RequestMapping("/api/tuan/waitcomment")
	@ResponseBody
	public ResultData orderStatusTowaitComment(Long id) {
		TuanOrder tuanOrder = orderService.findById(id);
		tuanOrder.setOrderStatus(TuanOrderStatus.WAIT_COMMENT.name());
		orderService.save(tuanOrder);
		
		ResultData result = new ResultData(true, "团订单已修改成待评价状态！");
		result.addData("tuanOrder", tuanOrder);
		return result;
	}
	
	/**
	 * 代收获
	 * @param id 团订单id
	 * @return tuan tuanOrder
	 */
	@RequestMapping("/api/tuan/waitshipping")
	@ResponseBody
	public ResultData orderStatusTowaitShipping(Long id) {
		TuanOrder tuanOrder = orderService.findById(id);
		tuanOrder.setOrderStatus(TuanOrderStatus.WAIT_SHIPPING.name());
		orderService.save(tuanOrder);
		
		ResultData result = new ResultData(true, "团订单已修改成待发货状态！");
		result.addData("tuanOrder", tuanOrder);
		return result;
	}
	
	/**
	 * 购买成功
	 * @param id 团订单id
	 * @return tuanOrder
	 */
	@RequestMapping("/api/tuan/successed")
	@ResponseBody
	public ResultData orderStatusToSuccessed(Long id) {
		TuanOrder tuanOrder = orderService.findById(id);
		tuanOrder.setOrderStatus(TuanOrderStatus.SUCCESSED.name());
		orderService.save(tuanOrder);
		
		ResultData result = new ResultData(true, "团订单已修改成购买成功状态！");
		result.addData("tuanOrder", tuanOrder);
		return result;
	}

	/**
	 * 待退货
	 * @param id 团订单id
	 * @return tuanOrder tuan
	 */
	@RequestMapping("/api/tuan/waitrefundgoods")
	@ResponseBody
	public ResultData orderStatusToWaitRefundGoods(Long id) {
		TuanOrder tuanOrder = orderService.findById(id);
		tuanOrder.setOrderStatus(TuanOrderStatus.WAIT_REFUND_GOODS.name());
		orderService.save(tuanOrder);
		Tuan tuan = tuanService.findById(tuanOrder.getTuan().getId());
		tuan.setTuanStatus(TuanStatus.FAIL.name());
		tuanService.save(tuan);
		
		ResultData result = new ResultData(true, "团订单已修改成待退货状态！");
		result.addData("tuanOrder", tuanOrder);
		result.addData("tuan", tuan);
		return result;
	}

	/**
	 * 待退款
	 * @param id 团订单id
	 * @return tuanOrder
	 */
	@RequestMapping("/api/tuan/waitrefundmoney")
	@ResponseBody
	public ResultData orderStatusToWaitRefundMoney(Long id) {
		TuanOrder tuanOrder = orderService.findById(id);
		tuanOrder.setOrderStatus(TuanOrderStatus.WAIT_REFUND_MONEY.name());
		orderService.save(tuanOrder);
		
		ResultData result = new ResultData(true, "团订单已修改成待退款状态！");
		result.addData("tuanOrder", tuanOrder);
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
		ResultData result = new ResultData(true, "团详情");
		Tuan tuan = tuanService.find(id);
		if(tuan!=null){
			List<TuanOrder> orderList = orderService.findAllByTuanId(tuan.getId());
			result.addData("tuan", tuan);
			result.addData("orderList", orderList);
		}
		return result;
	}
	
	
	
}
