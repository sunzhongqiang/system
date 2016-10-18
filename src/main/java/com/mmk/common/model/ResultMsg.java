package com.mmk.common.model;

public class ResultMsg<T> implements java.io.Serializable {

	/**
	 * 默认生成的序列号
	 */
	private static final long serialVersionUID = 1L;

	private boolean success = false;

	private String msg = "";

	private T obj = null;
	
	public ResultMsg() {
	}
	
	public ResultMsg(boolean success,String msg){
		this.success = success;
		this.msg = msg;
	}
	
	public ResultMsg(boolean success,String msg,T object){
		this.success = success;
		this.msg = msg;
		this.obj = object;
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

	public Object getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

}
