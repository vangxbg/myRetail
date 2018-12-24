package com.myRetail.apiApplication.Controllers.Resources;

public class PriceResource {

	public Double value;
	public String currencyCode;
	
	public PriceResource() {
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
