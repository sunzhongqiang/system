package com.mmk.task.trade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mmk.business.constants.GroupGoods;
import com.mmk.business.model.GoodsGroup;
import com.mmk.business.service.GoodsGroupService;
import com.mmk.refund.service.RefundService;
import com.mmk.trade.condition.TuanOrderStatus;
import com.mmk.trade.condition.TuanStatus;
import com.mmk.trade.model.Tuan;
import com.mmk.trade.model.TuanOrder;
import com.mmk.trade.service.TuanOrderService;
import com.mmk.trade.service.TuanService;
import com.mmk.weixin.service.MessageTemplateService;

@Service
public class TradeHourJob {

	protected Log log = LogFactory.getLog(this.getClass());

	@Resource
	private TuanService tuanService;
	@Resource
	private TuanOrderService orderService;
	@Resource
	private MessageTemplateService templateService;
	@Resource
	private RefundService refundService;
	@Resource
	private GoodsGroupService goodsGroupService;

	/**
	 * 定时检查团订单是否到期
	 */
	@Scheduled(cron = "1 0/10 * * * ?")
	public void checkOvertime() {
		log.info("当前时间：" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));

		//关闭未成团的订单
		closeTimeoutOrder();
		
		//到期抽取
		chooseLucker();
	}

	private void closeTimeoutOrder() {
		log.info("关闭定时订单");
		for (int i = 0;; i++) {
			Pageable pageable = new PageRequest(i, 500);
			Page<Tuan> tuanPage = tuanService.findAllOvertime(TuanStatus.WAIT_JOIN.name(), pageable);
			log.info("获取未成团到期团订单：" + tuanPage.getNumberOfElements() + "总计条数：" + tuanPage.getTotalElements());
			List<Tuan> content = tuanPage.getContent();
			for (Tuan tuan : content) {
				tuan.setTuanStatus(TuanStatus.FAIL.name());
				List<TuanOrder> orders = orderService.findAllByTuanId(tuan.getId());
				for (TuanOrder tuanOrder : orders) {
					tuanOrder.setOrderStatus(TuanOrderStatus.CLOSED.name());
					orderService.save(tuanOrder);
					Map<String, Object> data = new HashMap<String,Object>();
					data.put("openid", tuanOrder.getUser().getOpenid());
					data.put("first", "你有一个团超时关闭了");
					data.put("keyword1", tuanOrder.getOrderPrice());
					data.put("keyword2", tuan.getGoodsName());
					data.put("keyword3", tuanOrder.getAddress());
					data.put("keyword4", tuanOrder.getOrderCode());
					data.put("remark", "订单关闭");
					templateService.closeMessage(data);
					refundService.refundByOrderId(tuanOrder.getId());
					
				}
				tuanService.save(tuan);
			}
			if (!tuanPage.hasNext()) {
				break;
			}
		}
	}
	
	public void chooseLucker(){
		log.info("定时进行抽奖");
		for (int i = 0;; i++) {
			Pageable pageable = new PageRequest(i, 500);
			Page<GoodsGroup> page = goodsGroupService.findAllOverTime(2l,GroupGoods.WAIT_CHOOSE.name(),pageable);
			log.info("获取未成团到期团订单：" + page.getNumberOfElements() + "总计条数：" + page.getTotalElements());
			
			for (GoodsGroup goodsGroup : page) {
				orderService.chooseLuckerByGroupId(goodsGroup.getId());
				goodsGroup.setStatus(GroupGoods.FINISHED.name());
				goodsGroupService.save(goodsGroup);
			}
			if (!page.hasNext()) {
				break;
			}
		}
	}

}
