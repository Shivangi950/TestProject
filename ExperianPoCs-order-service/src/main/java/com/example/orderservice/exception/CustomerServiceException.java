package com.example.orderservice.exception;

public class CustomerServiceException extends RuntimeException {

	private static final long serialVersionUID = -470180507998010368L;

	public CustomerServiceException() {
		super();
	}

	public CustomerServiceException(final String message) {
		super(message);
	}

}
