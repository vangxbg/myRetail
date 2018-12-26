package apiApplication.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import apiApplication.model.Product;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements IProductService {

//	@Autowired
    private ProductRepo productRepo;

    @Override
    public Mono<Product> findOne(Long id) {
        return productRepo.findById(id).
                switchIfEmpty(Mono.error(new Exception("No Blog found with Id: " + id)));
    }
}