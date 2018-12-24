package com.myRetail.apiApplication;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ProductsController {
	
	@Autowired
	private PriceRepository repository;
    
    @RequestMapping(method=RequestMethod.GET, value="/products/{id}")
    public ProductResource GetProduct(RestTemplate restTemplate, @PathVariable Long id) {
    	
    	Price price = repository.findById(id).get();
    	
    	PriceResource priceResource = new PriceResource();
    	priceResource.currencyCode = price.getCurrencyCode();
    	priceResource.value = price.getValue();
    	
    	ProductResource productResource = new ProductResource();
    	productResource.id = price.getId();
    	productResource.price = priceResource;
    	
    	ExternalResource externalResource = restTemplate.getForObject("https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", ExternalResource.class);
    	productResource.name = externalResource.product.item.product_description.title; 	
    	    	
    	return productResource;
    }
}