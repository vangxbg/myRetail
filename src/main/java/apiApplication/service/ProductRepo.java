package apiApplication.service;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import apiApplication.model.Product;

@Repository
public interface ProductRepo extends ReactiveMongoRepository<Product, Long> {
	
}

