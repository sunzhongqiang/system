package com.mmk.weixin.service;

import java.util.Map;

public interface MessageTemplateService {
	
	
	public void sendMessage(String templateId,Map<String,Object> data);

}
