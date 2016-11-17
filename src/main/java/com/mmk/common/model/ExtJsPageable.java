package com.mmk.common.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

public class ExtJsPageable {

	private int page = 1;
	private int start = 0;
	private int limit = 25;
	// private String sort;
	private List<String> sort;

	public ExtJsPageable() {
		this.page = 1;
		this.limit = 25;
		this.start = 0;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public Pageable pageable() {
		if (sort != null) {
			List<Order> orderList = new ArrayList<Order>();
			for (String property : sort) {
				String[] split = property.split(" ");
				if (split.length > 1) {
					Direction dirction = "desc".equals(split[1].toLowerCase()) ? Direction.DESC : Direction.ASC;
					orderList.add(new Order(dirction, split[0]));
				} else {
					orderList.add(new Order(property));
				}
			}
			return new PageRequest(page - 1, limit, new Sort(orderList));
		}
		return new PageRequest(page - 1, limit);
	}

	public List<String> getSort() {
		return sort;
	}

	public void setSort(List<String> sort) {
		this.sort = sort;
	}

}
