package com.myRetail.apiApplication.Controllers.Resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalProductResource {
	public ExternalItemResource item;
	
	public ExternalProductResource() {
		
	}
	
	public ExternalItemResource getItem() {
		return item;
	}
	
	public void setItem(ExternalItemResource item) {
		this.item = item;
	}
}
