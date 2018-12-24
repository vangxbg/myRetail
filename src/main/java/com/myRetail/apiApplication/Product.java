package com.myRetail.apiApplication;

import org.springframework.data.annotation.Id;

public class Product {

    @Id
    public Long id;
    public String name;
    public Price price;

    public Product() {}
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setPrice(Price price) {
    	this.price = price;
    }
    
    public Long getId() {
    	return id;
    }
    
    public String getName() {
    	return name;
    }   
    
    public Price getPrice() {
    	return price;
    }    

}