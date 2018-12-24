package com.myRetail.apiApplication.Controllers.Resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalResource {
	public ExternalProductResource product;
	
	public ExternalResource() {}
	
	public Object getProduct() {
		return product;
	}
	
	public void setProduct(ExternalProductResource product) {
		this.product = product;
	}
	
}
