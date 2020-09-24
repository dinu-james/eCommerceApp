package com.sv.ecommerceapp.orders.ordersmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoOrderFoundException extends Exception {

    public NoOrderFoundException() {
        super("No Order found");
    }

}
