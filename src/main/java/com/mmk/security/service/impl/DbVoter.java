package com.mmk.security.service.impl;

import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import com.mmk.system.model.OperationLog;
import com.mmk.system.model.Privilege;
import com.mmk.system.service.OperationLogService;
import com.mmk.system.service.PrivilegeService;

@Component
public class DbVoter implements AccessDecisionVoter<FilterInvocation>{
	private Log log = LogFactory.getLog(getClass());
	@Resource
	private OperationLogService operationService;	
	@Resource
	private PrivilegeService privilegeService;	

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public int vote(Authentication authentication, FilterInvocation object, Collection<ConfigAttribute> attributes) {
		String requestURI = object.getHttpRequest().getRequestURI();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		log.debug(requestURI);
		int result = accessVote(requestURI,authorities);
		//记录日志
		recordLog(authentication.getName(),object);
		return result;
	}
	
	private int accessVote(String requestURI, Collection<? extends GrantedAuthority> authorities) {
		for (GrantedAuthority grantedauthority : authorities) {
			String authority = grantedauthority.getAuthority();
			if(hasRight(requestURI,authority)){
				return ACCESS_GRANTED;
			}
		}
		return ACCESS_ABSTAIN;
	}

	private boolean hasRight(String requestURI, String authority) {
		return privilegeService.checkRight(authority,requestURI);
	}

	private void recordLog(String name, Object object) {
		if(object instanceof FilterInvocation){
			FilterInvocation invocation = (FilterInvocation) object;
			HttpServletRequest httpRequest = invocation.getHttpRequest();
			OperationLog log = new OperationLog();
			log.setFunctionName("");
			log.setOperationTime(new Date());
			log.setUsername(name);
			log.setFunctionUri(invocation.getRequestUrl());
			log.setIp(httpRequest.getRemoteHost());
			log.setRealname(httpRequest.getRemoteUser());
			operationService.save(log);
		}
	}

}
