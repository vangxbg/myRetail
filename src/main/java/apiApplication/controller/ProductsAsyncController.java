package apiApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apiApplication.model.Product;
import apiApplication.service.IProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/api/async")
@Component
public class ProductsAsyncController {
	
	@Autowired
    private IProductService productService;
    
    @RequestMapping(method=RequestMethod.GET, value="/products")
    public List<Product> getProduct() {
    	
    	// will need a cron job to actively fetch data from external api, and product will need to be saved into
    	// database during the http put request for price
    	return productService.findAll();    	
    	
    }
}
