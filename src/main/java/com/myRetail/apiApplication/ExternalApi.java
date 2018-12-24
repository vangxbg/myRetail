package com.myRetail.apiApplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalApi {
	ExternalProduct product;
	
	public ExternalApi() {}
	
	public Object getProduct() {
		return product;
	}
	
	public void setProduct(ExternalProduct product) {
		this.product = product;
	}
	
}
