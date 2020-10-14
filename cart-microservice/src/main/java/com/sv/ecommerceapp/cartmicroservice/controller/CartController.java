package com.sv.ecommerceapp.cartmicroservice.controller;

import com.sv.ecommerceapp.cartmicroservice.model.Cart;
import com.sv.ecommerceapp.cartmicroservice.service.CartService;
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

    /***
     * List<Long> as parameter yet to be decided.
     * we can have one product at a time
     * @param productIds
     * @return
     */
    @RequestMapping(value ="/createCart",method= RequestMethod.POST)
    public ResponseEntity<Cart> createCart(Long productId){
        Cart cart = cartService.createCart(productId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
    
    /***
     * Deletes the cart once the order is placed
     * And not individual product
     * @param cartId
     * @return
     */
    @RequestMapping(value ="/deleteCart/{cartId}",method=RequestMethod.DELETE)
    public ResponseEntity<Cart> deleteCart(@PathVariable("cartId") Long cartId){
        Cart cart = cartService.deleteCart(cartId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
    
    
    
    @PostMapping(value = "/cart", params = {"productId", "quantity"})
    private ResponseEntity addItemToCart(
            @RequestParam("productId") Long productId,
            @RequestParam("quantity") Integer quantity,
            @RequestHeader(value = "Cookie") String cartId) {
        List<Object> cart = cartService.getCart(cartId);
        if(cart.isEmpty()){
            cartService.addItemToCart(cartId, productId, quantity);
        }else{
            if(cartService.checkIfItemIsExist(cartId, productId)){
                cartService.changeItemQuantity(cartId, productId, quantity);
            }else {
                cartService.addItemToCart(cartId, productId, quantity);
            }
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    /**
     1. delete individual product from cart using product id
     2. getAllProducts - same as catalogue
     - same as catalogue
     - total amount must be calculated here, method call
     */
    
    /*
     *  @GetMapping (value = "/cart")
    private ResponseEntity<List<Object>> getCart(@RequestHeader(value = "Cookie") String cartId){
        List<Object> cart = cartService.getCart(cartId);
        return new ResponseEntity<List<Object>>(cart, HttpStatus.OK);
    }

    @PostMapping(value = "/cart", params = {"productId", "quantity"})
    private ResponseEntity addItemToCart(
            @RequestParam("productId") Long productId,
            @RequestParam("quantity") Integer quantity,
            @RequestHeader(value = "Cookie") String cartId) {
        List<Object> cart = cartService.getCart(cartId);
        if(cart.isEmpty()){
            cartService.addItemToCart(cartId, productId, quantity);
        }else{
            if(cartService.checkIfItemIsExist(cartId, productId)){
                cartService.changeItemQuantity(cartId, productId, quantity);
            }else {
                cartService.addItemToCart(cartId, productId, quantity);
            }
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/cart", params = "productId")
    private ResponseEntity removeItemFromCart(
            @RequestParam("productId") Long productId,
            @RequestHeader(value = "Cookie") String cartId){
        cartService.deleteItemFromCart(cartId, productId);
        return new ResponseEntity(HttpStatus.OK);
    }
     */
     */
}
