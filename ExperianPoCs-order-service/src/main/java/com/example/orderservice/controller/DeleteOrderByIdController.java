package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.controllerapi.DeleteOrderApi;
import com.example.orderservice.model.ExceptionResponse;
import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class DeleteOrderByIdController implements DeleteOrderApi {

	@Autowired
	OrderService orderService;

	@ApiOperation(value = "delete Order By orderId", nickname = "deleteOrderOrderIdDelete", notes = "you can delete order by orderId ", response = Order.class, tags = {
			"orders", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "search results matching criteria", response = Order.class),
			@ApiResponse(code = 404, message = "search order not found", response = ExceptionResponse.class) })
	@RequestMapping(value = "/deleteOrder/{orderId}", produces = { "application/json",
			"application/xml" }, method = RequestMethod.DELETE)
	public ResponseEntity<Order> deleteOrderOrderIdDelete(
			@ApiParam(value = "", required = true) @PathVariable("orderId") Integer orderId) {
		Order deletedOrder = orderService.deleteOrderById(orderId);
		return new ResponseEntity<>(deletedOrder, HttpStatus.OK);
	}
}