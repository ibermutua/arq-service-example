package es.ibermutua.services.arqexampleservice.business;

import java.util.List;

import es.ibermutua.services.arqexampleservice.dao.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product saveProduct(Product product);

}
