package es.ibermutua.services.arqexampleservice.web;

import es.ibermutua.services.arqexampleservice.TestUtils;
import es.ibermutua.services.arqexampleservice.business.ProductService;
import es.ibermutua.services.arqexampleservice.dao.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductControllerTest {
	@Autowired
	protected MockMvc mvc;

	@LocalServerPort
	int randomServerPort;

	@MockBean
	ProductService service;

	@Test
	public void testFindProductsReturnsArray() throws Exception {

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(getURI("/api/v1/products"))
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Product[] productlist = TestUtils.mapFromJson(content, Product[].class);
		Assert.assertNotNull(productlist);
	}

	@Test
	public void testPostProduct() throws Exception {
		Product prToAdd = new Product();
		prToAdd.setDescripcion("HOLA");
		prToAdd.setNombre("NALA");
		prToAdd.setNumeroSerie("11111");


		Product prAdded = new Product();
		prAdded.setDescripcion("HOLA");
		prAdded.setId(1L);
		prAdded.setNombre("NALA");
		prAdded.setNumeroSerie("11111");

		when(service.saveProduct(any(Product.class))).thenReturn(prAdded);

		mvc.perform(MockMvcRequestBuilders.post(getURI("/api/v1/product"))
				.content(TestUtils.mapToJson(prToAdd))
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.descripcion").value(prAdded.getDescripcion()));

		mvc.perform(MockMvcRequestBuilders.post(getURI("/api/v1/product"))
				.content(TestUtils.mapToJson(prToAdd))
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber());

	}

	private URI getURI(String path) throws URISyntaxException {
		return new URI("http://localhost:" + randomServerPort + path);
	}


}
