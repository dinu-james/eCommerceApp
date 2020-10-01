package com.sv.ecommerceapp.orders.ordersmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoOrderFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoOrderFoundException() {
        super("No Order found");
    }
	
	public NoOrderFoundException(String msg) {
        super(msg);
    }

}
