package com.myRetail.apiApplication.Models;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
	@Id
	public Long id;
	public Double value;
	public String currencyCode;
	
	public Price() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	public Double getValue() {
		return value;
	}
	
	public String getCurrencyCode() {
		return currencyCode;
	}
}
