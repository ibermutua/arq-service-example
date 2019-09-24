package es.ibermutua.services.arqexampleservice.repositories;

import org.springframework.data.repository.CrudRepository;

import es.ibermutua.services.arqexampleservice.data.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
