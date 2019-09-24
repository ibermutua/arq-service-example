package es.ibermutua.services.arqexampleservice.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ibermutua.services.arqexampleservice.data.domain.Product;
import es.ibermutua.services.arqexampleservice.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value="Sistema de gestion de productos", description="Operaciones relativas a los productos")
public class ProductController {
	@Autowired
	ProductService productService;
	
	
	@ApiOperation(value = "View a list of products", response = List.class)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		    @ApiResponse(code = 500, message = "Error retrieving the data")
		})
	@GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Product> getAllProducts (){
		return productService.getAllProducts ();
	}
	
	@PostMapping(path="/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Save a product", response = Product.class)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully saved product"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		    @ApiResponse(code = 500, message = "Error saving the data")
		})
	public Product saveProduct (@RequestBody Product product) {
		return productService.saveProduct (product);

	}
}
