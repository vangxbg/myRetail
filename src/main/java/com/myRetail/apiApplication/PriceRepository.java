package com.myRetail.apiApplication;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PriceRepository extends MongoRepository<Price, Long> {

}

