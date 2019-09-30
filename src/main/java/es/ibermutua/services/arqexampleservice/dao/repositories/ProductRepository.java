package es.ibermutua.services.arqexampleservice.dao.repositories;

import es.ibermutua.services.arqexampleservice.dao.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findProductsByNombre(String nombre);
}
