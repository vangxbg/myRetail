package apiApplication.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class External {
	private ExternalProduct product;
	
	public External() {}
	
	public ExternalProduct getProduct() {
		return product;
	}
	
	public void setProduct(ExternalProduct product) {
		this.product = product;
	}
	
}
