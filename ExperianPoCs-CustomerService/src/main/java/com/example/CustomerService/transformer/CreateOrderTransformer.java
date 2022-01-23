package com.example.CustomerService.transformer;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.util.CollectionUtils;

import com.example.CustomerService.Service.ProductService;
import com.example.CustomerService.model.Customer;
import com.example.CustomerService.model.InputOrder;
import com.example.CustomerService.model.InputOrderProduct;
import com.example.CustomerService.model.Order;
import com.example.CustomerService.model.OrderProduct;
import com.example.CustomerService.model.Product;
import com.example.CustomerService.model.Order.OrdStatusEnum;

public class CreateOrderTransformer {
	ProductService productService;
	
	private CreateOrderTransformer(ProductService productService) {
		this.productService = productService;
	}
	
	public static CreateOrderTransformer getInstance(ProductService productService) {
		return new CreateOrderTransformer(productService);
	}
	
	
	
	public Order populateOrder(InputOrder inputOrder, Customer customer) {
		Order order = new Order();
		order.setCustomer(customer);
		BigDecimal totalValue = BigDecimal.ZERO;
		if (!CollectionUtils.isEmpty(inputOrder.getOrderProducts())) {
			
			for (InputOrderProduct eachOrderProduct: inputOrder.getOrderProducts()) {
				Integer productId = eachOrderProduct.getProductId();
				
				Product product = productService.getProductById(productId);
				
				addProductToOrder(order, product, eachOrderProduct);
				
				totalValue = totalValue.add(product.getProductPrice().multiply(new BigDecimal(eachOrderProduct.getQuantity())));
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
