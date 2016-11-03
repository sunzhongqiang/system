package com.mmk.common.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class EasyPageable {
	
	//页面
	private Integer page;
	private Integer rows;
	private String sort;
	private String order;
	
	public EasyPageable() {
		this.page =1 ;
		this.rows = 50;
	}
	
	
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
	
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public Pageable pageable(){
		checkNull();
		if(StringUtils.isNoneBlank(sort)){
			Direction dirction = "desc".equals(order) ? Direction.DESC :Direction.ASC;
			return new PageRequest(page-1, rows,new Sort(dirction,sort ));
		}
	    return new PageRequest(page-1, rows);
	}
	
	private void checkNull(){
		if(this.page==null){
			this.page = 1;
		} 
		if(this.rows == null){
			this.rows = 50;
		}
	}
	
	
	

}
