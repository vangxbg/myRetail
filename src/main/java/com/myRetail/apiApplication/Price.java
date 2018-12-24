package com.myRetail.apiApplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
	public Double value;
	public String currencyCode;
	
	public Price() {
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
