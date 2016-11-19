package com.mmk.security.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import com.mmk.system.model.LoginLog;
import com.mmk.system.model.User;
import com.mmk.system.model.UserRole;
import com.mmk.system.service.LoginLogService;
import com.mmk.system.service.UserRoleService;
import com.mmk.system.service.UserService;

@Service
public class AuthenticationManagerImpl implements AuthenticationManager {

	@Resource
	private LoginLogService loginLogService;	
	@Resource
	private UserService userService;
	@Resource
	private UserRoleService userRoleService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		Object details = authentication.getDetails();
		
		String remoteAddress = "";
		if (details instanceof WebAuthenticationDetails) {
			WebAuthenticationDetails webDetails = (WebAuthenticationDetails) details;
			remoteAddress = webDetails.getRemoteAddress();
		}
		
		String username = authentication.getName();
		User user =  userService.findByUsername(username);
		if(null!=user){
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
			if (encoder.matches(authentication.getCredentials().toString(), user.getPassword())){
				Collection<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
				//获取用户角色
				List<UserRole> userRoles = userRoleService.findAllByUserId(user.getId());
				
				for (UserRole userRole : userRoles) {
					roles.add(new SimpleGrantedAuthority(String.valueOf(userRole.getRoleId())));
				}
				
				LoginLog loginLog = new LoginLog();
				loginLog.setIp(remoteAddress);
				loginLog.setRealname(user.getRealname());
				loginLog.setUsername(user.getUsername());
				loginLog.setLoginTime(new Date());
				loginLog.setStatus("成功登录");
				loginLogService.save(loginLog );
				return new UsernamePasswordAuthenticationToken(user.getRealname(),authentication.getCredentials(), roles);
			}else{
				LoginLog loginLog = new LoginLog();
				loginLog.setIp(remoteAddress);
				loginLog.setRealname(user.getRealname());
				loginLog.setUsername(user.getUsername());
				loginLog.setLoginTime(new Date());
				loginLog.setStatus("密码错误");
				loginLogService.save(loginLog );
			} 
		}else{
			LoginLog loginLog = new LoginLog();
			loginLog.setIp(remoteAddress);
			loginLog.setUsername(username);
			loginLog.setLoginTime(new Date());
			loginLog.setStatus("非法用户");
			loginLogService.save(loginLog );
		}
		throw new BadCredentialsException("用户或密码出错");
	}

}
