package com.test.pagination.enums;

public enum OrderBy {
	
	ID("filmId");
	
	private String OrderByCode;
	
	private OrderBy(String orderBy) {
		this.OrderByCode = orderBy;
	}
	public String getOrderByCode() {
		return this.OrderByCode;
	}
	
}
