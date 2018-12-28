package apiApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiApplication.model.Product;
import apiApplication.repository.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements IProductService {

	@Autowired
    public ProductRepository productRepository;

    @Override
    public Product findOne(Integer id) {
        return productRepository.findById(id).get();
    }

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
}
