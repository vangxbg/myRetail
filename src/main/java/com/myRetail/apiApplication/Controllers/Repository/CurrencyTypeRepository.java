package com.myRetail.apiApplication.Controllers.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myRetail.apiApplication.Models.CurrencyType;

public interface CurrencyTypeRepository extends MongoRepository<CurrencyType, String> {
	
}

