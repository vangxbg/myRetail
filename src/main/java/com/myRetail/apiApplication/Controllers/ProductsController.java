package com.myRetail.apiApplication.Controllers;
import org.springframework.web.client.RestTemplate;

import com.myRetail.apiApplication.Controllers.Resources.ExternalResource;
import com.myRetail.apiApplication.Controllers.Resources.PriceResource;
import com.myRetail.apiApplication.Controllers.Resources.ProductResource;
import com.myRetail.apiApplication.Models.Price;

import java.util.EnumMap;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ProductsController {
	
	@Autowired
	private PriceRepository priceRepository;
	
	@Autowired
	private CurrencyTypeRepository currencyTypeRepository;
	
    @Autowired
    private ModelMapper modelMapper;
    
    @RequestMapping(method=RequestMethod.GET, value="/products/{id}")
    public ProductResource GetProduct(RestTemplate restTemplate, @PathVariable Long id) {
    	
    	Price price = priceRepository.findById(id).get();
    	
    	PriceResource priceResource = new PriceResource();
    	modelMapper.map(price, priceResource);
    	
    	ExternalResource externalResource = restTemplate.getForObject("https://redsky.target.com/v2/pdp/tcin/"+id+"?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", ExternalResource.class);
    	
    	ProductResource productResource = new ProductResource();
    	productResource.id = id;
    	productResource.name = externalResource.product.item.product_description.title; 
    	productResource.price = priceResource;	
    	    	
    	return productResource;
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
    public ResponseEntity<?> UpdateProduct(RestTemplate restTemplate, @PathVariable Long id, @RequestBody PriceResource priceResource) {
    	
    	Price price = priceRepository.findById(id).get();
    	
    	if(!currencyTypeRepository.findById(priceResource.currencyCode).isPresent()) {
    		return new ResponseEntity<>("That currency code does not exist, please try a different code", HttpStatus.BAD_REQUEST);
    	}
    	
    	modelMapper.map(priceResource, price);
    	priceRepository.save(price);
    	
    	ExternalResource externalResource = restTemplate.getForObject("https://redsky.target.com/v2/pdp/tcin/"+id+"?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", ExternalResource.class);
    	
    	ProductResource productResource = new ProductResource();
    	productResource.id = id;
    	productResource.name = externalResource.product.item.product_description.title; 
    	productResource.price = priceResource;	    	
    	
    	return new ResponseEntity<>(productResource, HttpStatus.OK);
    }
}