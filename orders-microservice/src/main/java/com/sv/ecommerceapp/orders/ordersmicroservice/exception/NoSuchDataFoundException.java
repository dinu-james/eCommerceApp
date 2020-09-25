package com.sv.ecommerceapp.orders.ordersmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchDataFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchDataFoundException() {
		super();
	}

	public NoSuchDataFoundException(String message) {
		super(message);
	}
	


}
