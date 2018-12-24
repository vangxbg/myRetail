package com.myRetail.apiApplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
	ProductDescription product_description;
	
	public Item() {
		
	}
	
	public ProductDescription getProduct_description() {
		return product_description;
	}
	
	public void setProduct_description(ProductDescription product_description) {
		this.product_description = product_description;
	}
}
