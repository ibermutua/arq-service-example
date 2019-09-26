package es.ibermutua.services.arqexampleservice.dao.repositories;

import es.ibermutua.services.arqexampleservice.dao.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
