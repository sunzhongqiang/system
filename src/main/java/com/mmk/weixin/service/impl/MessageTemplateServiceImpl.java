package com.mmk.weixin.service.impl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.mmk.common.tool.ApiClient;
import com.mmk.weixin.service.MessageTemplateService;

@Service
public class MessageTemplateServiceImpl implements MessageTemplateService {

	 private Log log = LogFactory.getLog(this.getClass());
	 
	@Override
	public void sendMessage(String templateId, Map<String, Object> data) {
		String url = "http://wx.yiqingo.net/Api/Team/InTeam";
		data.put("templateId", templateId);
		String result = ApiClient.post(url , data);
		
		log.debug(result);
	}

}
