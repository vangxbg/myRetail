package apiApplication.model;

import org.springframework.data.annotation.Id;

public class Product {
	@Id
	private Integer id;
	private String name;
	private Price price;
	
	public Product() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(Price price) {
		this.price = price;
	}
	
	public Price getPrice() {
		return price;
	}
}
