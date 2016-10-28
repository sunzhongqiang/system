package com.mmk.api;

import com.mmk.business.model.WxUser;
import com.mmk.common.model.ResultMsg;

public interface WxUserApi {
	
	ResultMsg save(WxUser user);

}
