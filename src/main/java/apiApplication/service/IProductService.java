package apiApplication.service;

import apiApplication.model.Product;
import reactor.core.publisher.Mono;

public interface IProductService {
	
    Mono<Product> findOne(Long id);

}

