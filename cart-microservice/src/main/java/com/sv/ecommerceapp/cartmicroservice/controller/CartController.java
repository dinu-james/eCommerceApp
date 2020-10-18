package com.sv.ecommerceapp.cartmicroservice.controller;

import com.sv.ecommerceapp.cartmicroservice.model.Cart;
import com.sv.ecommerceapp.cartmicroservice.service.CartService;
import com.sv.ecommerceapp.cartmicroservice.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value ="/addToCart/{productId}/{quantity}",method= RequestMethod.POST)
    public ResponseEntity<String> createCart(@PathVariable("productId") Long productId , @PathVariable("quantity") int quantity){
        Cart cart = cartService.addItemToCart(productId,quantity);
        return new ResponseEntity<>("Item Added to cart", HttpStatus.OK);
    }

    @RequestMapping(value ="/retrieveCart",method= RequestMethod.GET)
    public Cart retrieveCart(){
        Cart cart = cartService.retrieveCart();
        return cart;
    }

    @RequestMapping(value ="/removeItemFromCart/{productId}",method= RequestMethod.POST)
    public ResponseEntity<String> createCart(@PathVariable("productId") Long productId ){
         cartService.removeItem(productId);
        return new ResponseEntity<>("Item Removed", HttpStatus.OK);
    }

    @RequestMapping(value ="/deleteCart",method= RequestMethod.DELETE)
    public ResponseEntity<String> deleteCart(){
        cartService.deleteCart();
        return new ResponseEntity<>("Cart Deleted", HttpStatus.OK);
    }
}
