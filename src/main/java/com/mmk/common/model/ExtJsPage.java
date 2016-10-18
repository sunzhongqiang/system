package com.mmk.common.model;

import java.util.List;

import org.springframework.data.domain.Page;

public class ExtJsPage<T> {
	
	private boolean success = true;
	private long total = 0l;
	
	private List<T> content;
	

	public ExtJsPage(Page<T> page){

		this.setContent(page.getContent());
		
		this.total = page.getTotalElements();
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}
}
