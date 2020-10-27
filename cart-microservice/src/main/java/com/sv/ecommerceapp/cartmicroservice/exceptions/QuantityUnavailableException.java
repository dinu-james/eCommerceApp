package com.sv.ecommerceapp.cartmicroservice.exceptions;

public class QuantityUnavailableException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public QuantityUnavailableException(String msg) {
		super(msg);
	}
	public QuantityUnavailableException(String msg, Exception e) {
		super(msg, e);
	}
}
