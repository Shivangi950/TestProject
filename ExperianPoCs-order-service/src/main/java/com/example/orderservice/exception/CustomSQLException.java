package com.example.orderservice.exception;

public class CustomSQLException extends RuntimeException {

	private static final long serialVersionUID = -470180507998010368L;

	public CustomSQLException() {
		super();
	}

	public CustomSQLException(final String message) {
		super(message);
	}

}
