package com.sv.ecommerceapp.orders.ordersmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NoOrderFoundException.class)
    public ResponseEntity OrderNotFound(NoOrderFoundException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
