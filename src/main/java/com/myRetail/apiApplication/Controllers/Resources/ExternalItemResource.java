package com.myRetail.apiApplication.Controllers.Resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalItemResource {
	public ExternalProductDescriptionResource product_description;
	
	public ExternalItemResource() {
		
	}
	
	public ExternalProductDescriptionResource getProduct_description() {
		return product_description;
	}
	
	public void setProduct_description(ExternalProductDescriptionResource product_description) {
		this.product_description = product_description;
	}
}
