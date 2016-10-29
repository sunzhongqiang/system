package com.mmk.api.impl;

import java.util.HashMap;
import java.util.Map;

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
	public ResultMsg findUser(String openid) {
		WxUser user = wxUserService.findBy("openid", openid);
		if(user==null){
			return new ResultMsg(false,"用户不存在");
		}else{
			Map<String, Object> result = new HashMap<String,Object>();
			result.put("user", user);
			return new ResultMsg(true,"查找成功",result );
		}
	}

}
