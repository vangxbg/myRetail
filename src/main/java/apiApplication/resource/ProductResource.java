package apiApplication.resource;

public class ProductResource {

    private Integer id;
    private String name;
    private PriceResource price;

    public ProductResource() {}
    
    public void setId(Integer id) {
    	this.id = id;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setPrice(PriceResource price) {
    	this.price = price;
    }
    
    public Integer getId() {
    	return id;
    }
    
    public String getName() {
    	return name;
    }   
    
    public PriceResource getPrice() {
    	return price;
    }    

}