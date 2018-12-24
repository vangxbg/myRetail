package com.myRetail.apiApplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalProductResource {
	ExternalItemResource item;
	
	public ExternalProductResource() {
		
	}
	
	public ExternalItemResource getItem() {
		return item;
	}
	
	public void setItem(ExternalItemResource item) {
		this.item = item;
	}
}
