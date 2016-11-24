package com.mmk.api.bill;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.constants.TuanConstant;
import com.mmk.business.model.Goods;
import com.mmk.business.model.GoodsGroup;
import com.mmk.business.model.WxUser;
import com.mmk.business.service.GoodsGroupService;
import com.mmk.business.service.GoodsService;
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
	public ResultData join(Tuan tuan) {

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

	@RequestMapping("/api/tuan/open")
	@ResponseBody
	public ResultData open(WxUser user, Goods goods) {

		ResultData result = new ResultData(false, "正在实现");
		return result;
	}

	@RequestMapping("/api/tuan/build")
	@ResponseBody
	public ResultData build(WxUser user, Long groupId) {
		GoodsGroup group = groupService.find(groupId);
		Goods goods = group.getGoods();
		Tuan tuan = new Tuan();
		tuan.setGoodsId(goods.getId());
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
	
	
	@RequestMapping("/api/tuan/list")
	@ResponseBody
	public ResultData list(String openid,Long status,Pageable pageable) {
		Page<Tuan> tuanList = tuanService.listByOpenId(openid,status,pageable);
		ResultData result = new ResultData(false, "正在实现");
		return result;
	}
}
