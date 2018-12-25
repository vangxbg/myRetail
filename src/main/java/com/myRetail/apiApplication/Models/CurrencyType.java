package com.myRetail.apiApplication.Models;

import org.springframework.data.annotation.Id;

public class CurrencyType {
	
	@Id
	public String id;
	
	public CurrencyType() {
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}
