package com.example.CustomerService.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerService.Controllerapi.AddProductApi;
import com.example.CustomerService.Service.ProductService;
import com.example.CustomerService.model.ExceptionResponse;
import com.example.CustomerService.model.InputProduct;
import com.example.CustomerService.model.Product;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddProductController implements AddProductApi {

	@Autowired
	ProductService productService;

	@ApiOperation(value = "add product", nickname = "addProductPost", notes = "add product ", response = Product.class, tags = {
			"products", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = Product.class),
			@ApiResponse(code = 400, message = "invalid input, object invalid", response = ExceptionResponse.class),
			@ApiResponse(code = 409, message = "Product already exists", response = ExceptionResponse.class) })
	@RequestMapping(value = "/addProduct", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" }, method = RequestMethod.POST)
	public ResponseEntity<Product> addProductPost(
			@ApiParam(value = "product to add") @Valid @RequestBody InputProduct inputProduct) {
		Product addedProduct = productService.createProduct(inputProduct);
		return new ResponseEntity<>(addedProduct, HttpStatus.OK);
	}
	
	
@ApiOperation(value = "add product", nickname = "addProductPost", notes = "add product ", response = Product.class, tags = {
		"products", })
@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = Product.class),
		@ApiResponse(code = 400, message = "invalid input, object invalid", response = ExceptionResponse.class),
		@ApiResponse(code = 409, message = "Product already exists", response = ExceptionResponse.class) })
@RequestMapping(value = "/deductInventory/{quantity}", produces = { "application/json", "application/xml" }, consumes = {
		"application/json", "application/xml" }, method = RequestMethod.POST)
public ResponseEntity<Product> deductInventoryPost(
		@ApiParam(value = "inventory to delete") @Valid @RequestBody Integer productId, @ApiParam(value = "", required = true) @PathVariable("quantity") Integer quantity) {
	Product updatedProduct = productService.deductInventory(productId, quantity);
	return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
  }
}
