package com.sv.ecommerceapp.orders.ordersmicroservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/status/test")
    public String test (){
        return "Orders-microservice is up !";
    }

}
