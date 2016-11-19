package com.mmk.common.tool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 文件上传客户端，使用httpclient mini-mulit 进行文件上传<br/>
 * 
 * <pre>
 * FileClient client = new FileClient(host,port,uri);
 * String body = client.upload(dir,name,file).getBody();
 * or
 * Map<String,Object> json = client.upload(dir,name,file).getJson();
 * or
 * String imgUrl = client.upload(dir,name,file).getImageUrl();
 * </pre>
 * 
 * @author 孙中强 sunzhongqiang
 * @since 2015-12-28
 *
 */
public class FileClient {

	// 配置参数
	private String host;
	private int prot = 80;
	private String uri;

	// 返回结果
	private String body;
	private Map<String, Object> json;
	private String imageUrl;
	private Log log = LogFactory.getLog(getClass());

	/**
	 * 构造文件服务器客户端
	 * 
	 * @param host　 图片服务器地址或者域名：192.168.1.131 or 127.0.0.1 or img.yiqingo.com
	 * @param port　图片服务器的端口 80 8080 12000 默认为80端口
	 * @param uri　图片服务器的接口地址 /upload
	 */
	public FileClient(String host, int port, String uri) {
		this.host = host;
		this.prot = port;
		this.uri = uri;
	}

	/**
	 * 
	 * @return 返回默认配置的图片服务器客户端
	 */
	public static FileClient getDefault() {
		return new FileClient("img.yiqingo.com", 80, "/upload");
	}

	/**
	 * 上传文件到指定位置
	 * 
	 * @param dir　存储的路径
	 * @param name　文件名
	 * @param file　文件
	 * @return 客户端
	 */
	public FileClient upload(String dir, String name, File file) {
		CloseableHttpClient createDefault = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			HttpPost post = new HttpPost(uri);
			HttpEntity entity = MultipartEntityBuilder.create().addBinaryBody("file", file).addTextBody("dir", dir)
					.addTextBody("name", name).addTextBody("timestamp", DateTime.now().toString("yyyyMMddHHmmss"))
					.build();
			post.setEntity(entity);
			// 执行请求
			response = createDefault.execute(new HttpHost(host, prot), post);
			// 处理返回结果
			this.body = getResult(response);
			return this;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				System.out.println("--打印释放资源----"+body.getBytes());
				if(null!=response){
					response.close();
				}
				if(null!=createDefault){
					createDefault.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 上传商品图片
	 */
	public Map<String,Object> uploadGoods(String originalimgDir, String name, File originalimgfile,
			String goodsimgDir,  File goodsimgfile,
			String thumbimgDir,  File thumbimgfile) {
		Map<String, Object> result = new HashMap<String,Object>();
		
		CloseableHttpClient createDefault = HttpClients.createDefault();		
		HttpPost post = new HttpPost(uri);
		try {
			HttpEntity entity = MultipartEntityBuilder.create().addBinaryBody("file", originalimgfile).addTextBody("dir", originalimgDir)
					.addTextBody("name", name).addTextBody("timestamp", DateTime.now().toString("yyyyMMddHHmmss"))
					.build();
			post.setEntity(entity);
			CloseableHttpResponse originalimgResponse = createDefault.execute(new HttpHost(host, prot), post);
			try {  
				result.put("originalImgArr", this.getImgUrl(originalimgResponse.getEntity()));
		    } catch(Exception e){
		    	throw e;
		    } finally {  
		    	if(null!=originalimgResponse){
		    		originalimgResponse.close();
				}
		    }  
			
			entity = MultipartEntityBuilder.create().addBinaryBody("file", goodsimgfile).addTextBody("dir", goodsimgDir)
					.addTextBody("name", name).addTextBody("timestamp", DateTime.now().toString("yyyyMMddHHmmss"))
					.build();
			post.setEntity(entity);
			CloseableHttpResponse goodsimgResponse = createDefault.execute(new HttpHost(host, prot), post);
			try {  
				result.put("goodsImgArr", this.getImgUrl(goodsimgResponse.getEntity()));
			} catch(Exception e){
			    throw e;
			} finally {
		    	if(null!=goodsimgResponse){
		    		goodsimgResponse.close();
				}
		    } 
			
			entity = MultipartEntityBuilder.create().addBinaryBody("file", thumbimgfile).addTextBody("dir", thumbimgDir)
					.addTextBody("name", name).addTextBody("timestamp", DateTime.now().toString("yyyyMMddHHmmss"))
					.build();
			post.setEntity(entity);
			CloseableHttpResponse thumbimgResponse = createDefault.execute(new HttpHost(host, prot), post);
			try {  
				result.put("thumbImgArr", this.getImgUrl(thumbimgResponse.getEntity()));
		    } catch(Exception e){
			    throw e;
			} finally { 
		    	if(null!=thumbimgResponse){
		    		thumbimgResponse.close();
				}
		    }
			return result;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				log.info("--上传商品图片后释放资源----");
				if(null!=createDefault){
					createDefault.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 获得response的结果，并以String形式返回
	 * 
	 * @param response
	 * @return String 结果
	 * @throws IOException
	 */
	public String getImgUrl(HttpEntity httpEntity) throws IOException {
		if (httpEntity != null) {
			this.body = EntityUtils.toString(httpEntity, "UTF-8");
			if (body != null) {
				ObjectMapper mapper = new ObjectMapper();				
				Map<String, Object> result = mapper.readValue(body.getBytes(), Map.class);
				this.json = result;
				this.imageUrl = result.get("url") == null ? null : result.get("url").toString();
				return imageUrl;
			}
		}
		return null;
	}

	/**
	 * 上传文件到指定位置
	 * 
	 * @param dir　存储的路径
	 * @param name　文件名
	 * @param file　文件
	 * @return 客户端
	 */
	public FileClient upload(String dir, String name, byte[] filebyte) {
		CloseableHttpClient createDefault = HttpClients.createDefault();
		try {
			HttpPost post = new HttpPost(uri);
			HttpEntity entity = MultipartEntityBuilder.create().addBinaryBody("file", filebyte).addTextBody("dir", dir)
					.addTextBody("name", name).addTextBody("timestamp", DateTime.now().toString("yyyyMMddHHmmss"))
					.build();
			post.setEntity(entity);
			// 执行请求
			CloseableHttpResponse response = createDefault.execute(new HttpHost(host, prot), post);
			// 处理返回结果
			this.body = getResult(response);
			return this;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public FileClient upload(String dir, MultipartFile file) throws IOException {
		File dest = Files.write(Files.createTempFile("copy", "temp"), file.getBytes()).toFile();
		return upload(dir, file.getOriginalFilename(), dest);
	}

	/**
	 * 获得response的结果，并以String形式返回
	 * 
	 * @param response
	 * @return String 结果
	 * @throws IOException
	 */
	public String getResult(final HttpResponse response) throws IOException {
		// 得到httpResponse的实体数据
		HttpEntity httpEntity = response.getEntity();
		if (httpEntity != null) {
			this.body = EntityUtils.toString(httpEntity, "UTF-8");
			log.debug(body);
			if (body != null) {
				ObjectMapper mapper = new ObjectMapper();				
				Map<String, Object> result = mapper.readValue(body.getBytes(), Map.class);
				this.json = result;
				this.imageUrl = result.get("url") == null ? null : result.get("url").toString();
			}
			return body;
		}
		return null;
	}

	public boolean isSuccess(HttpResponse response) {
		// 得到httpResponse的状态响应码
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == HttpStatus.SC_OK) {
			return true;
		}
		return false;
	}

	public String getBody() {
		return body;
	}

	public Map<String, Object> getJson() {
		return json;
	}

	public String getImageUrl() {
		return imageUrl;
	}

}

