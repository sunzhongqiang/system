package com.mmk.weixin.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mmk.common.tool.ApiClient;
import com.mmk.weixin.constants.WeiXinOpenParams;
import com.mmk.weixin.model.WxAppAuth;
import com.mmk.weixin.service.WxAppAuthService;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

@RestController
public class AuthorizationController {

	protected Log log = LogFactory.getLog(this.getClass());
	private String authorizationUrl = WeiXinOpenParams.AUTHORIZATION_URL + "?component_appid="
			+ WeiXinOpenParams.COMPONENT_APPID + "&redirect_uri=" + WeiXinOpenParams.REDIRECT_URI + "&pre_auth_code=";
	
	@Resource
	private WxAppAuthService wxAuthAppService;

	@RequestMapping("/weixin/auth")
	public ModelAndView auth() {
		JSONObject object = new JSONObject();
		object.put("component_appid", WeiXinOpenParams.COMPONENT_APPID);
		String preAuthCode = ApiClient.postJson(WeiXinOpenParams.PRE_AUTH_CODE_URL + "?component_access_token="
				+ WeiXinOpenParams.COMPONENT_ACCESS_TOKEN, object);
		JSONObject json = new JSONObject(preAuthCode);
		preAuthCode = json.getString("pre_auth_code");

		return new ModelAndView(new RedirectView(authorizationUrl + preAuthCode));
	}

	@RequestMapping("/weixin/preAuthCode")
	public String preAuthCode() {
		JSONObject object = new JSONObject();
		object.put("component_appid", WeiXinOpenParams.COMPONENT_APPID);
		String preAuthCode = ApiClient.postJson(WeiXinOpenParams.PRE_AUTH_CODE_URL + "?component_access_token="
				+ WeiXinOpenParams.COMPONENT_ACCESS_TOKEN, object);
		JSONObject json = new JSONObject(preAuthCode);
		preAuthCode = json.getString("authorization_info");
		return preAuthCode;
	}
	
	@RequestMapping("/weixin/authCode")
	public String authCode(String auth_code,String expires_in) {
		JSONObject object = new JSONObject();
		object.put("component_appid", WeiXinOpenParams.COMPONENT_APPID);
		object.put("authorization_code", auth_code);
		String result = ApiClient.postJson("https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token="
				+ WeiXinOpenParams.COMPONENT_ACCESS_TOKEN, object);
		log.info(result);
		JSONObject json = new JSONObject(result);
		JSONObject info = json.getJSONObject("authorization_info");
		String authorizerAppid = info.getString("authorizer_appid");
		String authorizerAccessToken = info.getString("authorizer_access_token");
		Integer expiresIn = info.getInt("expires_in");
		String authorizerRefreshToken = info.getString("authorizer_refresh_token");
		WxAppAuth authApp = wxAuthAppService.findByAuthorizerAppid(authorizerAppid);
		if(authApp==null){
			authApp = new WxAppAuth();
			authApp.setAuthorizerAppid(authorizerAppid);
		}
		authApp.setAuthorizerAccessToken(authorizerAccessToken);
		authApp.setExpiresIn(Long.valueOf(expiresIn));
		authApp.setAuthorizerRefreshToken(authorizerRefreshToken);
		authApp.setModified(new Date());
		wxAuthAppService.save(authApp);
		return result;
	}

	/**
	 * 获取token ,这个可以手动获取，这个也设置了定时任务进行自动获取
	 * 
	 * @return
	 */
	@RequestMapping("/weixin/token")
	public String token() {
		JSONObject params = new JSONObject();
		params.put("component_appid", WeiXinOpenParams.COMPONENT_APPID);
		params.put("component_appsecret", WeiXinOpenParams.COMPONENT_APPSECRET);
		params.put("component_verify_ticket", WeiXinOpenParams.COMPONENT_VERIFY_TICKET);
		log.info("ticket:" + WeiXinOpenParams.COMPONENT_VERIFY_TICKET);
		String token = ApiClient.postJson(WeiXinOpenParams.COMPONENT_ACCESS_TOKEN_URL, params);
		JSONObject json = new JSONObject(token);
		WeiXinOpenParams.COMPONENT_ACCESS_TOKEN = json.getString("component_access_token");
		log.debug("token:" + token);
		return token;
	}

	@RequestMapping("/weixin/callback")
	@ResponseBody
	public String callback(HttpServletRequest request, @RequestBody String xml) {
		String nonce = request.getParameter("nonce");
		String timestamp = request.getParameter("timestamp");
		String signature = request.getParameter("signature");
		String msgSignature = request.getParameter("msg_signature");
		log.info("nonce:" + nonce);
		log.info("timestamp:" + timestamp);
		log.info("signature:" + signature);
		log.info("msgSignature:" + msgSignature);
		log.info("xml:" + xml);
		try {
			WXBizMsgCrypt pc = new WXBizMsgCrypt(WeiXinOpenParams.COMPONENT_TOKEN, WeiXinOpenParams.ENCODEING_KEY,
					WeiXinOpenParams.COMPONENT_APPID);
			String decryptMsg = pc.decryptMsg(msgSignature, timestamp, nonce, xml);
			Map<String, String> map = getMapFromXml(decryptMsg);
			WeiXinOpenParams.COMPONENT_VERIFY_TICKET = map.get("ComponentVerifyTicket");
			log.debug("获得ticket:" + WeiXinOpenParams.COMPONENT_VERIFY_TICKET);
		} catch (AesException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return "success";
	}

	public Map<String, String> getMapFromXml(String xml) {
		try {
			Document doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> elements = rootElt.elements();
			Map<String, String> result = new HashMap<String, String>();
			for (Element element : elements) {
				result.put(element.getName(), element.getText());
			}
			return result;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;

	}
}
