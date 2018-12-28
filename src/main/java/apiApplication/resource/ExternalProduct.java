package apiApplication.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalProduct {
	private ExternalItem item;
	
	public ExternalProduct() {
		
	}
	
	public ExternalItem getItem() {
		return item;
	}
	
	public void setItem(ExternalItem item) {
		this.item = item;
	}
}
