package com.sv.ecommerceapp.cartmicroservice.controller;

import com.sv.ecommerceapp.cartmicroservice.model.Cart;
import com.sv.ecommerceapp.cartmicroservice.service.CartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping("/status/test")
    public String test(){
        return "Cart-microservice is up !";
    }

    @ApiOperation("Create cart using individual productId and quantity")
    @RequestMapping(value ="/addToCart/{productId}/{quantity}",method= RequestMethod.POST)
    public String createCart(@PathVariable("productId") Long productId , @PathVariable("quantity") int quantity){
        Cart cart = cartService.addItemToCart(productId,quantity);
        return "Item Added to cart";
    }

    @ApiOperation("Retrieve all items from cart")
    @RequestMapping(value ="/retrieveCart",method= RequestMethod.GET)
    public Cart retrieveCart(){
        Cart cart = cartService.retrieveCart();
        return cart;
    }

    @ApiOperation("Remove an item from cart using product ID")
    @RequestMapping(value ="/removeItemFromCart/{productId}",method= RequestMethod.POST)
    public String removeItem(@PathVariable("productId") Long productId ){
         cartService.removeItem(productId);
        return "Item Removed";
    }

    @ApiOperation("Clear the cart, preferably once the order is placed")
    @RequestMapping(value ="/clearCart",method= RequestMethod.DELETE)
    public String clearCart(){
        cartService.clearCart();
        return "Cart Deleted";
    }
}
