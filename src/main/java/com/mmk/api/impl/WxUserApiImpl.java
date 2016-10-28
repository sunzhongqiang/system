package com.mmk.api.impl;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.api.WxUserApi;
import com.mmk.business.model.WxUser;
import com.mmk.business.service.WxUserService;
import com.mmk.common.model.ResultMsg;

@RestController
public class WxUserApiImpl implements WxUserApi {
	
	@Resource
	private WxUserService wxUserService;

	@RequestMapping("/api/user/save")
	@Override
	public ResultMsg save(WxUser user) {
		WxUser wxUser = wxUserService.findBy("openid", user.getOpenid());
		if(wxUser==null){
			//新增用户逻辑
			wxUserService.save(user);
			return new ResultMsg(true, "用户新增成功");
			
		}
		return new ResultMsg(false,"用户已经存在！");
	}
	
	@RequestMapping("/api/user/login")
	@Override
	public ResultMsg login(WxUser user) {
		WxUser wxUser = wxUserService.findBy("openid", user.getOpenid());
		if(wxUser==null){
			//新增用户逻辑
			wxUserService.save(user);
			return new ResultMsg(true, "用户新增成功");
			
		}
		return new ResultMsg(false,"用户已经存在！");
	}

	@RequestMapping("/api/user/findUser")
	@Override
	public WxUser findUser(String openid) {
		return wxUserService.findBy("openid", openid);
	}

}
