package com.myRetail.apiApplication.Controllers.Resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalProductDescriptionResource {
	public String title;
	
	public ExternalProductDescriptionResource() {
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
