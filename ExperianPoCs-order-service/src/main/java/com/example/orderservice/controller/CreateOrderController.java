package com.example.orderservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.controllerapi.CreateOrderApi;
import com.example.orderservice.model.ExceptionResponse;
import com.example.orderservice.model.InputOrder;
import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CreateOrderController implements CreateOrderApi {
	
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
		
		Order addedOrder = orderService.createOrderWithException(inputOrder);
		return new ResponseEntity<>(addedOrder, HttpStatus.OK);
	}
}
