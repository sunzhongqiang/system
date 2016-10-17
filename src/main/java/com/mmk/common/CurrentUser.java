package com.mmk.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.mmk.system.model.User;

/**
 * 相当于session 安全框架回话持有，便于获取当前用户的一些信息
 * @author 孙中强 sunzhognqiang
 * @since 2016-03-11
 *
 */
public class CurrentUser {

	
	public static User getUser(){
		Object details = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(details instanceof User){
			return (User) details;
		}
		return null;
	}
	
	
	public static   Authentication getAuthentication(){
		return  SecurityContextHolder.getContext().getAuthentication();
	}
	
}
