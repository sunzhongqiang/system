package com.mmk.security.service.impl;

import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import com.mmk.system.model.OperationLog;
import com.mmk.system.service.OperationLogService;

@Component
public class DbVoter implements AccessDecisionVoter<FilterInvocation>{
	private Log log = LogFactory.getLog(getClass());
	@Resource
	private OperationLogService operationService;	

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
		return false;
	}

	private void recordLog(String name, Object object) {
		if(object instanceof FilterInvocation){
			FilterInvocation invocation = (FilterInvocation) object;
			OperationLog log = new OperationLog();
			log.setFunctionName("");
			log.setOperationTime(new Date());
			log.setUsername(name);
			log.setFunctionUri(invocation.getRequestUrl());
			operationService.save(log);
		}
	}

}
