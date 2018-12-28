package apiApplication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import apiApplication.model.Price;

public interface PriceRepository extends MongoRepository<Price, Integer> {
	
}

