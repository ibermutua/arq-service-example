package es.ibermutua.services.arqexampleservice.services;

import java.util.List;

import es.ibermutua.services.arqexampleservice.data.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product saveProduct(Product product);

}
