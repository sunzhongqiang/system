package com.mmk.weixin.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mmk.common.tool.ApiClient;
import com.mmk.weixin.constants.WeiXinOpenParams;

@Service
public class TokenTask {

	protected Log log = LogFactory.getLog(this.getClass());

	/**
	 * 定时检查团订单是否到期
	 */
	@Scheduled(cron = "0 0/10 * * * ?")
	public void checkOvertime() {
		log.info("当前时间：" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));

		JSONObject params = new JSONObject();
		params.put("component_appid", WeiXinOpenParams.COMPONENT_APPID);
		params.put("component_appsecret", WeiXinOpenParams.COMPONENT_APPSECRET);
		params.put("component_verify_ticket", WeiXinOpenParams.COMPONENT_VERIFY_TICKET);
		String token = ApiClient.postJson(WeiXinOpenParams.COMPONENT_ACCESS_TOKEN_URL, params);
		log.debug("服务器返回："+token);
		JSONObject json = new JSONObject(token);
		WeiXinOpenParams.COMPONENT_ACCESS_TOKEN = json.getString("component_access_token");
		log.debug("token:"+WeiXinOpenParams.COMPONENT_ACCESS_TOKEN);
	}
}