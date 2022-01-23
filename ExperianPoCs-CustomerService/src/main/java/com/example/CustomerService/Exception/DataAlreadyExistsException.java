package com.example.CustomerService.Exception;

public class DataAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = -470180507998010368L;

	public DataAlreadyExistsException() {
		super();
	}

	public DataAlreadyExistsException(final String message) {
		super(message);
	}

}
