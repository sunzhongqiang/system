package com.mmk.security.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class APISecurityInterceptorAdapter extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		String timestamp = request.getParameter("timestamp");
//		String appid = request.getParameter("appid");
//		String appkey = "!!!weixinpintuan!!!";
//		String sign = request.getParameter("sign");
//		String uri = request.getRequestURI();
//		String rawPass = appkey+appid+timestamp+uri+appkey;
//		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
//		String encodePassword = md5.encodePassword(rawPass, null);
//		return encodePassword.equals(sign);
		
		return true;
	}

}
