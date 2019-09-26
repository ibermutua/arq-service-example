package es.ibermutua.services.arqexampleservice.business;

import es.ibermutua.services.arqexampleservice.dao.domain.Product;

import java.util.List;

public interface ProductService {

	List<Product> getAllProducts();

	Product saveProduct(Product product);

}
