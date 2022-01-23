package com.example.orderservice.transformer;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.example.orderservice.model.Customer;
import com.example.orderservice.model.InputOrder;
import com.example.orderservice.model.InputOrderProduct;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.Order.OrdStatusEnum;
import com.example.orderservice.model.OrderProduct;
import com.example.orderservice.model.Product;

public class CreateOrderTransformer {
	RestTemplate restTemplate;
	
	private CreateOrderTransformer(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public static CreateOrderTransformer getInstance(RestTemplate restTemplate) {
		return new CreateOrderTransformer(restTemplate);
	}
	
	public Order populateOrder(InputOrder inputOrder, Customer customer) {
		Order order = new Order();
		order.setCustomer(customer);
		BigDecimal totalValue = BigDecimal.ZERO;
		if (!CollectionUtils.isEmpty(inputOrder.getOrderProducts())) {
			
			for (InputOrderProduct eachOrderProduct: inputOrder.getOrderProducts()) {
				Integer productId = eachOrderProduct.getProductId();
				Integer quantity = eachOrderProduct.getQuantity();
				Product product = restTemplate.getForObject("http://localhost:8082/getProduct/{productId}", Product.class, productId);
				
				/**
				 * below will deduct inventory for the product
				 */
				restTemplate.postForObject("http://localhost:8082/deductInventory/{quantity}", productId, Product.class, quantity);
				addProductToOrder(order, product, eachOrderProduct);
				
				totalValue = totalValue.add(product.getProductPrice().multiply(new BigDecimal(quantity)));
			}
		}
		order.setOrderValue(totalValue);
		order.setOrdStatus(OrdStatusEnum.SUCCESS);
		return order;
	}

	private void addProductToOrder(Order order, Product product, InputOrderProduct eachOrderProduct) {
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setProduct(product);
			orderProduct.setQuantity(eachOrderProduct.getQuantity());
			orderProduct.setOrder(order);
			orderProduct.setDate(LocalDate.now());
			order.addOrderProductsItem(orderProduct);
	}
}
