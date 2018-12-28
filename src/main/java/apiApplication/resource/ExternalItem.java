package apiApplication.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalItem {
	private ExternalProductDescription product_description;
	
	public ExternalItem() {
		
	}
	
	public ExternalProductDescription getProduct_description() {
		return product_description;
	}
	
	public void setProduct_description(ExternalProductDescription product_description) {
		this.product_description = product_description;
	}
}
