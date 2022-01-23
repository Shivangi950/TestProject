package com.example.CustomerService.util;

import java.util.Optional;

import org.springframework.util.CollectionUtils;

import com.example.CustomerService.Exception.CustomerServiceException;
import com.example.CustomerService.model.InputOrder;
import com.example.CustomerService.model.InputOrderProduct;

public class OrderValidator {
	public static final String BAD_REQUEST_MESSAGE = "bad Request: Required field value is invalid";
	
	public static void validateOrder(InputOrder inputOrder) {
		if (!Optional.ofNullable(inputOrder.getCustomerId()).isPresent() || !validateOrderProducts(inputOrder)) {
			throw new CustomerServiceException(BAD_REQUEST_MESSAGE);
		}
	}
	
	private static boolean validateOrderProducts(InputOrder inputOrder) {
		boolean isValid = false;
		
		if (!CollectionUtils.isEmpty(inputOrder.getOrderProducts())) {
			isValid = true;
			for (InputOrderProduct inputOrderProduct : inputOrder.getOrderProducts()) {
				if (null == inputOrderProduct.getProductId() || null == inputOrderProduct.getQuantity()) {
					isValid = false;
					break;
				}
			}
		}
		return isValid;
	}
}
