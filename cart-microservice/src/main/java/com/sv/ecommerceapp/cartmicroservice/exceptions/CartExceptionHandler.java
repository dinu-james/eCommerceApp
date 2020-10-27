package com.sv.ecommerceapp.cartmicroservice.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.sv.ecommerceapp.cartmicroservice.model.ErrorResponse;


@ControllerAdvice
public class CartExceptionHandler {

	@ExceptionHandler(QuantityUnavailableException.class)
    public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(QuantityUnavailableException ex, 
    		WebRequest request) {
        ErrorResponse error = new ErrorResponse("INSUFFICIENT_STOCK", Arrays.asList(ex.getLocalizedMessage()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
