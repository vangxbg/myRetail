package apiApplication.controller;

import apiApplication.ApiApplication;
import apiApplication.model.Price;
import apiApplication.repository.CurrencyTypeRepository;
import apiApplication.repository.PriceRepository;
import apiApplication.resource.External;
import apiApplication.resource.PriceResource;
import apiApplication.resource.ProductResource;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
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
    public ResponseEntity<?> GetProduct(RestTemplate restTemplate, @PathVariable Integer id) {
    	
    	Price price = priceRepository.findById(id).get();
    	PriceResource priceResource = new PriceResource();
    	modelMapper.map(price, priceResource);
    	
    	External external = null;
    	try {
    		external = restTemplate.getForObject("https://redsky.target.com/v2/pdp/tcin/"+id+"?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", External.class);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<>("Internal error, was not able to fetch external api", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	ProductResource productResource = new ProductResource();
    	productResource.setId(id);
    	// can create a custom mapper if more information is mapped in the future
    	productResource.setName(external.getProduct().getItem().getProduct_description().getTitle());
    	productResource.setPrice(priceResource);
    	    	
    	return new ResponseEntity<>(productResource, HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
    public ResponseEntity<?> UpdateProduct(RestTemplate restTemplate, @PathVariable Integer id, @RequestBody @Valid PriceResource priceResource) {
    	    	
    	// making another call to the database to make sure currencyCode is valid (may need to be re-implemented to not make another database call)
    	if(!currencyTypeRepository.findById(priceResource.getCurrencyCode()).isPresent()) {
    		ResponseEntity<?> responseEntity = new ResponseEntity<>("That currency code does not exist, please try a different code", HttpStatus.BAD_REQUEST);
    		LOGGER.warn(String.format("Welcome to %s!", responseEntity), responseEntity);
    		return responseEntity;
    	}
    	Price price = priceRepository.findById(id).get();
    	modelMapper.map(priceResource, price);
    	priceRepository.save(price);
    	
    	// we may choose not to return this back to the user if not neccesary.
    	External external = null;
    	try {
    		external = restTemplate.getForObject("https://redsky.target.com/v2/pdp/tcin/"+id+"?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", External.class);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<>("Internal error, was not able to fetch external api", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	ProductResource productResource = new ProductResource();
    	productResource.setId(id);
    	// can create a custom mapper if more information is mapped in the future
    	productResource.setName(external.getProduct().getItem().getProduct_description().getTitle());
    	productResource.setPrice(priceResource);	

    	
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