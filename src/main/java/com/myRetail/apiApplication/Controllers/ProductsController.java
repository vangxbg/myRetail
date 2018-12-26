package com.myRetail.apiApplication.Controllers;
import org.springframework.web.client.RestTemplate;

import com.myRetail.apiApplication.ApiApplication;
import com.myRetail.apiApplication.Controllers.Repository.CurrencyTypeRepository;
import com.myRetail.apiApplication.Controllers.Repository.PriceRepository;
import com.myRetail.apiApplication.Controllers.Resources.ExternalResource;
import com.myRetail.apiApplication.Controllers.Resources.PriceResource;
import com.myRetail.apiApplication.Controllers.Resources.ProductResource;
import com.myRetail.apiApplication.Models.Price;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiApplication.class);
	
	@Autowired
	private PriceRepository priceRepository;
	
	@Autowired
	private CurrencyTypeRepository currencyTypeRepository;
	
    @Autowired
    private ModelMapper modelMapper;
    
    @RequestMapping(method=RequestMethod.GET, value="/products/{id}")
    public ResponseEntity<?> GetProduct(RestTemplate restTemplate, @PathVariable Long id) {
    	
    	Price price = priceRepository.findById(id).get();
    	
    	PriceResource priceResource = new PriceResource();
    	modelMapper.map(price, priceResource);
    	
    	ExternalResource externalResource = null;
    	try {
    		externalResource = restTemplate.getForObject("https://redsky.target.com/v2/pdp/tcin/"+id+"?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", ExternalResource.class);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<>("Internal error, was not able to fetch external api", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    	ProductResource productResource = new ProductResource();
    	productResource.id = id;
    	productResource.name = externalResource.product.item.product_description.title; 
    	productResource.price = priceResource;	
    	    	
    	return new ResponseEntity<>(productResource, HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
    public ResponseEntity<?> UpdateProduct(RestTemplate restTemplate, @PathVariable Long id, @RequestBody @Valid PriceResource priceResource) {
    
    	Price price = priceRepository.findById(id).get();
    	
    	if(!currencyTypeRepository.findById(priceResource.currencyCode).isPresent()) {
    		ResponseEntity<?> responseEntity = new ResponseEntity<>("That currency code does not exist, please try a different code", HttpStatus.BAD_REQUEST);
    		LOGGER.warn(String.format("Welcome to %s!", responseEntity), responseEntity);
    		return responseEntity;
    	}
    	
    	// attempting to save entered price value with 2 precision, will need to be fixed
    	BigDecimal twoPrecisionValue = new BigDecimal(priceResource.value.doubleValue()).setScale(2, RoundingMode.HALF_EVEN);
    	priceResource.value = twoPrecisionValue;
    	
    	modelMapper.map(priceResource, price);
    	priceRepository.save(price);
    	
    	ExternalResource externalResource = null;
    	try {
    		externalResource = restTemplate.getForObject("https://redsky.target.com/v2/pdp/tcin/"+id+"?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", ExternalResource.class);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<>("Internal error, was not able to fetch external api", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	ProductResource productResource = new ProductResource();
    	productResource.id = id;
    	productResource.name = externalResource.product.item.product_description.title; 
    	productResource.price = priceResource;	    	
    	
    	return new ResponseEntity<>(productResource, HttpStatus.OK);
    }
    
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}