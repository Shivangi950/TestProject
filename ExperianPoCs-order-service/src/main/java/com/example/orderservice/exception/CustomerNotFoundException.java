package com.example.orderservice.exception;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -470180507998010368L;
	
	public CustomerNotFoundException() {
		super();
	}
	
    public CustomerNotFoundException(String message)   {  
      super(message);  
    }   

 }

