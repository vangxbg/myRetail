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
	private ProductRepository repository;
	
    @RequestMapping(method=RequestMethod.GET, value="/products/{id}")
    public String GetProduct(RestTemplate restTemplate, @PathVariable Long id) {
    	ExternalApi externalApi = restTemplate.getForObject("https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", ExternalApi.class);
    	return externalApi.product.item.product_description.title;
//    	return repository.findById(id);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/products/{id}")
    public Product CreateProduct(RestTemplate restTemplate, @PathVariable Long id) {
    	Product testProduct = new Product();
    	testProduct.id = id;
    	testProduct.name = "Test Movie";
    	Price price = new Price();
    	price.value = 55.52;
    	price.currencyCode = "USD";
    	testProduct.price = price;
    	repository.save(testProduct);
    	return testProduct;
    }
    
}