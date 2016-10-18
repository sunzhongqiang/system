package com.mmk.common.model;

import java.util.HashMap;
import java.util.Map;

public class ResultMsg implements java.io.Serializable {

	/**
	 * 默认生成的序列号
	 */
	private static final long serialVersionUID = 1L;

	private boolean success = false;

	private String msg = "";

	private Map<String,Object> message = new HashMap<String, Object>();
	
	public ResultMsg() {
	}
	
	public ResultMsg(boolean success,String msg){
		this.success = success;
		this.msg = msg;
	}
	
	public ResultMsg(boolean success,String msg,Map<String,Object> message){
		this.success = success;
		this.msg = msg;
		this.setMessage(message);
	}
	

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String,Object> getMessage() {
		return message;
	}

	public void setMessage(Map<String,Object> message) {
		this.message = message;
	}

	

}
