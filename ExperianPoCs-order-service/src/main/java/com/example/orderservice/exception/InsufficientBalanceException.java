package com.example.orderservice.exception;

public class InsufficientBalanceException extends RuntimeException {

	private static final long serialVersionUID = -470180507998010368L;
	
	public InsufficientBalanceException() {
		super();
	}
	
    public InsufficientBalanceException(String message)   {  
      super(message);  
    }   

 }

