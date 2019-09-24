package es.ibermutua.services.arqexampleservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ibermutua.services.arqexampleservice.data.domain.Product;
import es.ibermutua.services.arqexampleservice.repositories.ProductRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	@Override
	public List<Product> getAllProducts() {
		return (List<Product>)productRepository.findAll();
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

}
