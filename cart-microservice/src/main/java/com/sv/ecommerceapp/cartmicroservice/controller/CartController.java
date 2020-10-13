package com.sv.ecommerceapp.cartmicroservice.controller;

import com.sv.ecommerceapp.cartmicroservice.model.Cart;
import com.sv.ecommerceapp.cartmicroservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping("/status/test")
    public String test(){
        return "Cart-microservice is up !";
    }

    @RequestMapping(value ="/createCart",method= RequestMethod.POST)
    public ResponseEntity<Cart> createCart(List<Long> productIds){
        Cart cart = cartService.createCart(productIds);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @RequestMapping(value ="/deleteCart/{cartId}",method=RequestMethod.DELETE)
    public ResponseEntity<Cart> deleteCart(@PathVariable("cartId") Long cartId){
        Cart cart = cartService.deleteCart(cartId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}
