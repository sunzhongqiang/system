package com.mmk.common.tool;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
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
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class ApiClient {

	public static CloseableHttpClient getClient() {
		ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
		SSLContext sslContext = SSLContexts.createSystemDefault();
		DefaultHostnameVerifier hostnameVerifier = new DefaultHostnameVerifier(null);
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
		        sslContext,
		        hostnameVerifier);
		Registry<ConnectionSocketFactory> r = RegistryBuilder.<ConnectionSocketFactory> create()
				.register("http", plainsf).register("https", sslsf).build();

		HttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(r);
		CloseableHttpClient client = HttpClients.custom().setConnectionManager(cm).build();
		return client;
	}

	public static String get(String url, Map<String, Object> params) {
		CloseableHttpClient createDefault = getClient();
		CloseableHttpResponse response = null;
		try {
			url = encodeUrl(url, params);
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
	
	public static String get(String url) {
		CloseableHttpClient createDefault = getClient();
		CloseableHttpResponse response = null;
		try {
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
		CloseableHttpClient createDefault = getClient();
		CloseableHttpResponse response = null;
		try {
			HttpPost post = new HttpPost(url);
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			for (String key : params.keySet()) {
				String value2 = String.valueOf(params.get(key));
				NameValuePair value = new BasicNameValuePair(key, value2);
				parameters.add(value);
			}

			UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(parameters,"UTF-8");
//			HttpEntity entity = EntityBuilder.create().setParameters(parameters).build();
			post.setEntity(urlEncodedFormEntity);
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
	public static String postJson(String url, JSONObject  params) {
		CloseableHttpClient createDefault = getClient();
		CloseableHttpResponse response = null;
		try {
			HttpPost post = new HttpPost(url);
			StringEntity entity = new StringEntity(params.toString(),"utf-8");
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
	
	
	public static String encodeUrl(String uri,Map<String,Object> params){
		StringBuffer url = new StringBuffer(uri);
		if(params==null||params.isEmpty()){
			return uri;
		}
		url.append("?");
		for (String key : params.keySet()) {
			url.append("&");
			url.append(key);
			url.append("=");
			url.append(String.valueOf(params.get(key)));
		}
		try {
			return  URLEncoder.encode(url.toString(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
}
