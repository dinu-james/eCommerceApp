package com.sv.ecommerceapp.orders.ordersmicroservice.controller;

import com.sv.ecommerceapp.orders.ordersmicroservice.model.Order;
import com.sv.ecommerceapp.orders.ordersmicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/status/test")
    public String test(){
        return "Orders-microservice is up !";
    }

    @GetMapping("/retrieve/{orderId}")
    public Optional<Order> retrieveByOrderID(@PathVariable("orderId") int orderId){
        return orderService.retrieveByOrderID(orderId);
    }

    @GetMapping("/createOrder")
    public String createOrder(){
         orderService.createOrder();
         return "Order Created";
    }

}
