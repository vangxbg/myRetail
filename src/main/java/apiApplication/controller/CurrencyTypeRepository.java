package apiApplication.controller;

import org.springframework.data.mongodb.repository.MongoRepository;

import apiApplication.model.CurrencyType;

public interface CurrencyTypeRepository extends MongoRepository<CurrencyType, String> {
	
}

