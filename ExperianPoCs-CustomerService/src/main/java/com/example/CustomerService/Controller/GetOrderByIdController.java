package com.example.CustomerService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerService.Controllerapi.GetOrderApi;
import com.example.CustomerService.Service.OrderService;
import com.example.CustomerService.model.ExceptionResponse;
import com.example.CustomerService.model.Order;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class GetOrderByIdController implements GetOrderApi {

	@Autowired
	OrderService orderService;

	@ApiOperation(value = "get order By orderId", nickname = "getOrderOrderIdGet", notes = "you can get order by orderId ", response = Order.class, tags = {
			"orders", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "search results matching criteria", response = Order.class),
			@ApiResponse(code = 404, message = "search order not found", response = ExceptionResponse.class) })
	@RequestMapping(value = "/getOrder/{orderId}", produces = { "application/json",
			"application/xml" }, method = RequestMethod.GET)
	public ResponseEntity<Order> getOrderOrderIdGet(
			@ApiParam(value = "", required = true) @PathVariable("orderId") Integer orderId) {
		Order order = orderService.getOrderById(orderId);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}
}