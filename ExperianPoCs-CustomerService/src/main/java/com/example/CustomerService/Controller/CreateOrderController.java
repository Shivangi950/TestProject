package com.example.CustomerService.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerService.Controllerapi.CreateOrderApi;
import com.example.CustomerService.Service.CustomerService;
import com.example.CustomerService.Service.OrderService;
import com.example.CustomerService.Service.ProductService;
import com.example.CustomerService.model.Customer;
import com.example.CustomerService.model.ExceptionResponse;
import com.example.CustomerService.model.InputOrder;
import com.example.CustomerService.model.Order;
import com.example.CustomerService.transformer.CreateOrderTransformer;
import com.example.CustomerService.util.OrderValidator;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CreateOrderController implements CreateOrderApi {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@ApiOperation(value = "create Order", nickname = "createOrderPost", notes = "create Order ", response = Order.class, tags = {
			"orders", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "order added successfully", response = Order.class),
			@ApiResponse(code = 400, message = "invalid input, object invalid", response = ExceptionResponse.class) })
	@RequestMapping(value = "/createOrder", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" }, method = RequestMethod.POST)
	public ResponseEntity<Order> createOrderPost(
			@ApiParam(value = "Order to add") @Valid @RequestBody InputOrder inputOrder) {
		
		OrderValidator.validateOrder(inputOrder);
		Customer customer = customerService.getCustomerById(inputOrder.getCustomerId());
		
		Order order = CreateOrderTransformer.getInstance(productService).populateOrder(inputOrder, customer);
		Order addOrder = orderService.addOrder(order);
		
		return new ResponseEntity<>(addOrder, HttpStatus.OK);
	}
}
