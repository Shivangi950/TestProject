package com.example.CustomerService.util;

import java.util.Optional;

import com.example.CustomerService.Exception.CustomerServiceException;
import com.example.CustomerService.model.InputProduct;

public class ProductValidator {
	public static final String BAD_REQUEST_MESSAGE = "bad Request: Required field value is invalid";
	
	public static void validateProduct(InputProduct inputProduct) {
		if (!Optional.ofNullable(inputProduct.getProductName()).isPresent() || !Optional.ofNullable(inputProduct.getProductPrice()).isPresent()
				|| !Optional.ofNullable(inputProduct.getCompany()).isPresent() || !Optional.ofNullable(inputProduct.getInventory()).isPresent()) {
			throw new CustomerServiceException(BAD_REQUEST_MESSAGE);
		}
	}
}
