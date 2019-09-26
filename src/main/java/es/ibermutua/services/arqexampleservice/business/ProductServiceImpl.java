package es.ibermutua.services.arqexampleservice.business;

import es.ibermutua.services.arqexampleservice.dao.domain.Product;
import es.ibermutua.services.arqexampleservice.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

}
