package apiApplication.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import apiApplication.model.Product;
import apiApplication.service.ProductService;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/api/async")
@Component
public class ProductsAsyncController {
	
	@Autowired
    private ProductService productService;
    
    @RequestMapping(method=RequestMethod.GET, value="/products/{id}")
    public Mono<Product> getProduct(@PathVariable Long id) {

    	return productService.findOne(id);
    	
    }
   
}
