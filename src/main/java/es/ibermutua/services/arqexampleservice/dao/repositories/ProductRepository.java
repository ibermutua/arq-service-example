package es.ibermutua.services.arqexampleservice.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import es.ibermutua.services.arqexampleservice.dao.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
