package es.ibermutua.services.arqexampleservice.business;

import es.ibermutua.services.arqexampleservice.dao.domain.Product;
import es.ibermutua.services.arqexampleservice.dao.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	@Mock
	ProductRepository repository;

	@InjectMocks
	ProductServiceImpl productService;

	@Test
	public void when_save_product_should_return_product_with_id() throws Exception {
		Product prToAdd = getProductToAdd();
		when(repository.save(any(Product.class))).thenReturn(getProductAdded());
		Product created = productService.saveProduct(prToAdd);
		Assert.assertEquals(created.getDescripcion(), prToAdd.getDescripcion());
		Assert.assertNotNull(created.getId());
	}

	@Test
	public void when_save_product_only_call_repository_once() throws Exception {
		Product prToAdd = getProductToAdd();
		when(repository.save(any(Product.class))).thenReturn(getProductAdded());
		productService.saveProduct(prToAdd);
		verify(repository, times(1)).save(prToAdd);
		verifyNoMoreInteractions(repository);
	}


	private Product getProductToAdd() {
		Product prToAdd = new Product();
		prToAdd.setDescripcion("HOLA");
		prToAdd.setNombre("NALA");
		prToAdd.setNumeroSerie("11111");
		return prToAdd;
	}

	private Product getProductAdded() {
		Product prToAdd = new Product();
		prToAdd.setId(1L);
		prToAdd.setDescripcion("HOLA");
		prToAdd.setNombre("NALA");
		prToAdd.setNumeroSerie("11111");
		return prToAdd;
	}
}
