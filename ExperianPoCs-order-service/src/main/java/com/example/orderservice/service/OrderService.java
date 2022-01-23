package com.example.orderservice.service;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.example.orderservice.exception.CustomerNotFoundException;
import com.example.orderservice.exception.InsufficientBalanceException;
import com.example.orderservice.model.Customer;
import com.example.orderservice.model.CustomerAmount;
import com.example.orderservice.model.InputOrder;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.Order.OrdStatusEnum;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.transformer.CreateOrderTransformer;
import com.example.orderservice.util.OrderValidator;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	 Queue queue;
		
	@Autowired
	JmsTemplate jmsTemplate;

	@Autowired
	private RestTemplate restTemplate;

	public Order addOrder(Order order) {
		Order addedOrder = null;
		try {
			addedOrder = orderRepository.save(order);
		} catch (Exception e) {
			System.out.println(e);
		}
		return addedOrder;
	}

	public Order getOrderById(int id) {
		Order order = null;
		try {
			order = orderRepository.findById(id).get();
		} catch (Exception e) {
			throw new CustomerNotFoundException("order not found");
		}
		return order;
	}

	public Order deleteOrderById(int id) {
		Order deletedOrder = null;
		try {
			Order order = orderRepository.findById(id).get();
			order.setOrdStatus(OrdStatusEnum.FAILED);
			deletedOrder = orderRepository.save(order);
		} catch (Exception e) {
			throw new CustomerNotFoundException("order not found");
		}
		return deletedOrder;
	}

	//@Transactional(rollbackFor = { InsufficientBalanceException.class })
	public Order createOrderWithException(@RequestBody InputOrder inputOrder)  {

		OrderValidator.validateOrder(inputOrder);
		Integer customerId = inputOrder.getCustomerId();
		Customer customer = restTemplate.getForObject("http://localhost:8082/getCustomer/{customerId}", Customer.class,
				customerId);

		Order order = CreateOrderTransformer.getInstance(restTemplate).populateOrder(inputOrder, customer);
		Order addOrder = addOrder(order);

		CustomerAmount customerAmount = new CustomerAmount();
		customerAmount.setCustomerId(customerId);
		customerAmount.setValue(order.getOrderValue());

		/**
		 * below will debit amount from customer.
		 */
		try {
			Customer updatedCustomer = restTemplate.postForObject("http://localhost:8082/debit", customerAmount,
					Customer.class);
		} catch (Exception e) {
			System.out.println("insufficient balance to book order");
			jmsTemplate.convertAndSend(queue,order.getOrderId());
			order.setOrdStatus(OrdStatusEnum.FAILED);
			throw new InsufficientBalanceException("balance insufficient");
		}
		return addOrder;
	}
}
