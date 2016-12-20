package com.mmk.weixin.web;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mmk.weixin.constants.WeiXinOpenParams;

@RestController
public class AuthorizationController {

	protected Log log = LogFactory.getLog(this.getClass());
	private String authorizationUrl = WeiXinOpenParams.AUTHORIZATION_URL + "?component_appid="
			+ WeiXinOpenParams.COMPONENT_APPID + "&pre_auth_code=" + WeiXinOpenParams.PRE_AUTH_CODE + "&redirect_uri="
			+ WeiXinOpenParams.REDIRECT_URI;

	@RequestMapping("/weixin/auth")
	public ModelAndView preAuthCode() {
		return new ModelAndView(new RedirectView(authorizationUrl));
	}

	@RequestMapping("/weixin/callback")
	@ResponseBody
	public String callback(HttpServletRequest request, @RequestBody String xml) {
		String nonce = request.getParameter("nonce");
		String timestamp = request.getParameter("timestamp");
		String signature = request.getParameter("signature");
		String msgSignature = request.getParameter("msg_signature");
		log.info("nonce:"+nonce);
		log.info("timestamp:"+timestamp);
		log.info("signature:"+signature);
		log.info("msgSignature:"+msgSignature);
		log.info("xml:"+xml);
		Map<String, String> result = getAuthorizerAppidFromXml(xml);
		for (String key : result.keySet()) {
			log.info(key+":"+result.get(key));
		}
		return "success";
	}

//	/**
//	 * 处理授权事件的推送
//	 * 
//	 * @param request
//	 * @throws IOException
//	 * @throws AesException
//	 * @throws DocumentException
//	 */
//	public void processAuthorizeEvent(HttpServletRequest request) throws IOException, DocumentException {
//		String nonce = request.getParameter("nonce");
//		String timestamp = request.getParameter("timestamp");
//		String signature = request.getParameter("signature");
//		String msgSignature = request.getParameter("msg_signature");
//
//		if (!StringUtils.isNotBlank(msgSignature))
//			return;// 微信推送给第三方开放平台的消息一定是加过密的，无消息加密无法解密消息
//		boolean isValid = checkSignature(COMPONENT_TOKEN, signature, timestamp, nonce);
//		if (isValid) {
//			StringBuilder sb = new StringBuilder();
//			BufferedReader in = request.getReader();
//			String line;
//			while ((line = in.readLine()) != null) {
//				sb.append(line);
//			}
//			String xml = sb.toString();
//			// LogUtil.info("第三方平台全网发布-----------------------原始 Xml="+xml);
//			String encodingAesKey = COMPONENT_ENCODINGAESKEY;// 第三方平台组件加密密钥
//			String appId = getAuthorizerAppidFromXml(xml);// 此时加密的xml数据中ToUserName是非加密的，解析xml获取即可
//			// LogUtil.info("第三方平台全网发布-------------appid----------getAuthorizerAppidFromXml(xml)-----------appId="+appId);
//			WXBizMsgCrypt pc = new WXBizMsgCrypt(COMPONENT_TOKEN, encodingAesKey, COMPONENT_APPID);
//			xml = pc.decryptMsg(msgSignature, timestamp, nonce, xml);
//			// LogUtil.info("第三方平台全网发布-----------------------解密后 Xml="+xml);
//			processAuthorizationEvent(xml);
//		}
//	}

	/**
	 * 判断是否加密
	 * 
	 * @param token
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String token, String signature, String timestamp, String nonce) {
		System.out.println(
				"###token:" + token + ";signature:" + signature + ";timestamp:" + timestamp + "nonce:" + nonce);
		boolean flag = false;
		if (signature != null && !signature.equals("") && timestamp != null && !timestamp.equals("") && nonce != null
				&& !nonce.equals("")) {
			String sha1 = "";
			String[] ss = new String[] { token, timestamp, nonce };
			Arrays.sort(ss);
			for (String s : ss) {
				sha1 += s;
			}

			MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-1");
				// 选择SHA-1，也可以选择MD5
				byte[] digest = md.digest(sha1.getBytes()); // 返回的是byet[]，要转化为String存储比较方便
				sha1 = new String(digest);
				if (sha1.equals(signature)) {
					flag = true;
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	
	public Map<String,String> getAuthorizerAppidFromXml(String xml){
		
		try {
			Document doc = DocumentHelper.parseText(xml);
			Element rootElt = doc.getRootElement();
			String toUserName = rootElt.elementText("ToUserName");
			List<Element> elements = rootElt.elements();
			Map<String,String> result = new HashMap<String,String>();
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
