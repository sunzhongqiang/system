package com.mmk.task.trade;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mmk.trade.condition.TuanOrderStatus;
import com.mmk.trade.condition.TuanStatus;
import com.mmk.trade.model.Tuan;
import com.mmk.trade.model.TuanOrder;
import com.mmk.trade.service.TuanOrderService;
import com.mmk.trade.service.TuanService;

@Service
public class TradeHourJob {

	protected Log log = LogFactory.getLog(this.getClass());

	@Resource
	private TuanService tuanService;
	@Resource
	private TuanOrderService orderService;

	/**
	 * 定时检查团订单是否到期
	 */
	@Scheduled(cron = "1 0 * * * ?")
	public void checkOvertime() {
		log.info("当前时间：" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));

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
				}
				tuanService.save(tuan);
			}
			if (!tuanPage.hasNext()) {
				break;
			}
		}
	}

}
