package com.mmk.api;

import com.mmk.business.model.WxUser;
import com.mmk.common.model.ResultMsg;

public interface WxUserApi {
	/**
	 * 用户保存
	 * @param user
	 * @return
	 */
	ResultMsg save(WxUser user);

	/**
	 * 用户登录
	 * @param user 要登录的用户
	 * @return
	 */
	ResultMsg login(WxUser user);
	
	/**
	 * 根据用户openid获取用户
	 * @param openid
	 * @return
	 */
	WxUser findUser(String openid);

}
