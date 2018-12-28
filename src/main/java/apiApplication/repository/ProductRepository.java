package apiApplication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import apiApplication.model.Product;
import reactor.core.publisher.Flux;

// heaving bean issues when using reactiveMongoRepository, will implement at a later time
public interface ProductRepository extends MongoRepository<Product, Integer> {

}