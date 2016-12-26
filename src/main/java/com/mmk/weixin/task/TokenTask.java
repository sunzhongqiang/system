package com.mmk.weixin.task;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mmk.common.tool.ApiClient;
import com.mmk.weixin.constants.WeiXinOpenParams;
import com.mmk.weixin.model.WxAppAuth;
import com.mmk.weixin.service.WxAppAuthService;
import com.mmk.weixin.service.WxAppConfigService;

@Service
public class TokenTask {

	protected Log log = LogFactory.getLog(this.getClass());
	
	@Resource
	private WxAppConfigService configService;
	@Resource
	private WxAppAuthService appService;

	/**
	 * 定时检查团订单是否到期
	 */
	@Scheduled(cron = "0 0 * * * ?")
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
		configService.refresh("COMPONENT_ACCESS_TOKEN",WeiXinOpenParams.COMPONENT_ACCESS_TOKEN,"COMPONENT_ACCESS_TOKEN");
		
	}
	
	/**
	 * 定时检查团订单是否到期
	 */
	@Scheduled(cron = "0 0/5 * * * ?")
	public void refreshAppToken() {
		log.info("刷新公众号的授权>>>当前时间：" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));

		List<WxAppAuth> authTimeouts = appService.findAllAuthTimeout(660);
		for (WxAppAuth wxAppAuth : authTimeouts) {
			JSONObject params = new JSONObject();
			params.put("component_appid", WeiXinOpenParams.COMPONENT_APPID);
			params.put("authorizer_appid", wxAppAuth.getAuthorizerAppid());
			params.put("authorizer_refresh_token", wxAppAuth.getAuthorizerRefreshToken());
			String result = ApiClient.postJson("https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token="+WeiXinOpenParams.COMPONENT_ACCESS_TOKEN, params);
			log.debug("服务器返回："+result);
			if(StringUtils.isNotBlank(result)){
				JSONObject json = new JSONObject(result);
				if(json.has("authorizer_access_token")){
					String accessToken = json.getString("authorizer_access_token");
					String authorizerRefreshToken = json.getString("authorizer_refresh_token");
					wxAppAuth.setAuthorizerAccessToken(accessToken);
					wxAppAuth.setAuthorizerRefreshToken(authorizerRefreshToken);
					wxAppAuth.setModified(new Date());
					appService.save(wxAppAuth);
				}
			}
		}
		
		
	}
}