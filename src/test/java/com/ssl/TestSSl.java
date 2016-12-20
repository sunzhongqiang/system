package com.ssl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import com.mmk.weixin.constants.WeiXinOpenParams;

public class TestSSl {

	@Test
	public void test() {
		
		ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
		
		SSLContext sslContext = SSLContexts.createSystemDefault();
		DefaultHostnameVerifier hostnameVerifier = new DefaultHostnameVerifier(null);
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
		        sslContext,
		        hostnameVerifier);
		Registry<ConnectionSocketFactory> r = RegistryBuilder.<ConnectionSocketFactory>create()
		        .register("http", plainsf)
		        .register("https", sslsf)
		        .build();

		HttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(r);
		CloseableHttpClient client = HttpClients.custom()
		        .setConnectionManager(cm)
		        .build();
		
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("component_appid", WeiXinOpenParams.COMPONENT_APPID);
		params.put("component_appsecret", WeiXinOpenParams.COMPONENT_APPSECRET);
		params.put("component_verify_ticket", "4eR8rPT8rKuTrMooh6sNiIQ9tacWcOKKDvrA0w");
		HttpPost request = new HttpPost("https://api.weixin.qq.com/cgi-bin/component/api_component_token");
		StringEntity entity = new StringEntity("{\"component_appid\":\"wx8dc8c585221427f\"},","utf-8");//解决中文乱码问题    
//		StringEntity entity = new StringEntity("{\"component_appid\":\"wx8dc8c585221427f\"},","utf-8");//解决中文乱码问题    
        entity.setContentEncoding("UTF-8");    
        entity.setContentType("application/json");    
		request.setEntity(entity);
		try {
			CloseableHttpResponse response = client.execute(request);
			String result = EntityUtils.toString(response.getEntity(), "UTF-8");
			System.out.println("this is : "+result);
			Assert.assertNotNull(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMap(){
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("component_appid", WeiXinOpenParams.COMPONENT_APPID);
		params.put("component_appsecret", WeiXinOpenParams.COMPONENT_APPSECRET);
		params.put("component_verify_ticket", "abc");
		System.out.println(params.toString());
	}
	@Test
	public void testJson(){
		JSONObject jsonParam = new JSONObject();  
		jsonParam.put("chnl_id", "11");// 红谷滩新闻资讯，channelId 77  
		jsonParam.put("title", "121");// 标题  
		jsonParam.put("content", 123);// 资讯内容  
		System.out.println(jsonParam.toString());
	}
	
	
	@Test
	public void testJson2(){
		String json = "{\"component_access_token\":\"eDUV70Ly0Hnplts9DUyHDb_hbo5SgGZVdKJNgiic1U0hU9wZD-AOOlx0MSzQjHx94g0BYvwBgbVUnp58uMhWDKMptzXtBiWMiDkeZm29J4ODRMyzubg5RltL4XlhW9iCLGOjAHAAVD\",\"expires_in\":7200}";
		
         System.out.println(new JSONObject(json));
	}

}
