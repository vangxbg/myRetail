package apiApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import apiApplication.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {
	
    Product findOne(Integer id);
    List<Product> findAll();
    
}

