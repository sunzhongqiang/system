package com.mmk.common.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class GridData<T> implements java.io.Serializable {

	/**
	 * 默认生成的序列UID
	 */
	private static final long serialVersionUID = -5692079074337736668L;
	
	private Long total = 0L;
	private List<T> rows = new ArrayList<T>();
	private List<T> footer = new ArrayList<T>();
	
	public GridData(Page<T> page){
		this.total = page.getTotalElements();
		this.rows = page.getContent();
	}
	

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public List<T> getFooter() {
		return footer;
	}

	public void setFooter(List<T> footer) {
		this.footer = footer;
	}

}
