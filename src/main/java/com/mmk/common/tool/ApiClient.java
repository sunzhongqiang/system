package com.mmk.common.tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class ApiClient {

	public static String get(String url, Map<String, Object> params) {
		CloseableHttpClient createDefault = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			url.concat("?");
			for (String key : params.keySet()) {
				url.concat("&").concat(key).concat("=").concat(String.valueOf(params.get(key)));
			}
			HttpGet get = new HttpGet(url);
			// 执行请求
			response = createDefault.execute(get);
			// 处理返回结果
			String result = EntityUtils.toString(response.getEntity(), "UTF-8");
			return result;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != response) {
					response.close();
				}
				if (null != createDefault) {
					createDefault.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String post(String url, Map<String, Object> params) {
		CloseableHttpClient createDefault = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			HttpPost post = new HttpPost(url);
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			for (String key : params.keySet()) {
				NameValuePair value = new BasicNameValuePair(key, String.valueOf(params.get(key)));
				parameters.add(value);
			}

			HttpEntity entity = EntityBuilder.create().setParameters(parameters).build();
			post.setEntity(entity);
			// 执行请求
			response = createDefault.execute(post);
			// 处理返回结果
			String result = EntityUtils.toString(response.getEntity(), "UTF-8");
			return result;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != response) {
					response.close();
				}
				if (null != createDefault) {
					createDefault.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
