package apiApplication.resource;

public class ProductResource {

    public Long id;
    public String name;
    public PriceResource price;

    public ProductResource() {}
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setPrice(PriceResource price) {
    	this.price = price;
    }
    
    public Long getId() {
    	return id;
    }
    
    public String getName() {
    	return name;
    }   
    
    public PriceResource getPrice() {
    	return price;
    }    

}