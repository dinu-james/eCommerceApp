package com.sv.ecommerceapp.orders.ordersmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(NoOrderFoundException.class)
    public ResponseEntity<Object> orderNotFound(NoOrderFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<Object> badRequest(BadRequest e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(NoSuchDataFoundException.class)
    public ResponseEntity<Object> noSuchDataFound(NoSuchDataFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    
}
