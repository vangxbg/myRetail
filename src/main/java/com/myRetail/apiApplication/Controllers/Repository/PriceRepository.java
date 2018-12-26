package com.myRetail.apiApplication.Controllers.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myRetail.apiApplication.Models.Price;

public interface PriceRepository extends MongoRepository<Price, Long> {
	
}

