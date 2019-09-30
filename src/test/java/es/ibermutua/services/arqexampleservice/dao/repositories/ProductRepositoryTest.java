package es.ibermutua.services.arqexampleservice.dao.repositories;

import es.ibermutua.services.arqexampleservice.TestUtils;
import es.ibermutua.services.arqexampleservice.dao.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ProductRepositoryTest {

	@Autowired
	ProductRepository repository;
	int nProductsExpected = 5;

	@Test
	public void findAll_returns_list() {

		Iterable<Product> products = repository.findAll();

		Assertions.assertThat(products).hasSize(nProductsExpected);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void should_error_if_name_length_greater_than_100() {
		Product p = getProductToAdd();
		p.setNombre(TestUtils.getStringWithSize(1211));
		repository.save(p);

		Iterable<Product> products = repository.findAll();
		Assertions.assertThat(products).hasSize(nProductsExpected + 1);

	}

	@Test
	public void should_save_entity() {
		Product p = getProductToAdd();
		p.setId(null);
		p.setNombre(TestUtils.getStringWithSize(12));
		repository.save(p);

		Iterable<Product> products = repository.findAll();
		Assertions.assertThat(products).hasSize(nProductsExpected + 1);

	}
	@Test
	public void should_return_product_when_find_by_name(){
		List<Product> products = repository.findProductsByNombre("producto 1");
		Assertions.assertThat(products).hasSize(1);
	}
	@Test
	public void should_return_product_empty_list_when_find_by_name_dont_retrieve_data(){
		List<Product> products = repository.findProductsByNombre("producto 131");
		Assertions.assertThat(products).isNotNull().hasSize(0);
	}

	private Product getProductToAdd() {
		Product p = new Product();
		p.setDescripcion("ajajajjaja");
		p.setNombre("asasasa");
		p.setNumeroSerie("asdasd a");
		return p;
	}
}
