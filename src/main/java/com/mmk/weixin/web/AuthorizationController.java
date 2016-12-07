package com.mmk.weixin.web;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mmk.weixin.constants.WeiXinOpenParams;

public class AuthorizationController {

	private String authorizationUrl = 
			WeiXinOpenParams.AUTHORIZATION_URL 
			+ "?component_appid="+ WeiXinOpenParams.COMPONENT_APPID 
			+ "&pre_auth_code=" + WeiXinOpenParams.PRE_AUTH_CODE 
			+ "&redirect_uri=" + WeiXinOpenParams.REDIRECT_URI;

	@RequestMapping("/weixin/auth")
	public ModelAndView preAuthCode() {
		return new ModelAndView(new RedirectView(authorizationUrl));
	}
	
	
	
	@RequestMapping("/weixin/callback")
	public ModelAndView callback(HttpServletRequest request) {
		for (Enumeration<String>  parameterNames = request.getParameterNames(); parameterNames.hasMoreElements();){
			
			String nextElement = parameterNames.nextElement();
			System.out.println(nextElement);
			System.out.println(request.getParameter(nextElement));
			
		}
		return new ModelAndView(new RedirectView(authorizationUrl));
	}

}
