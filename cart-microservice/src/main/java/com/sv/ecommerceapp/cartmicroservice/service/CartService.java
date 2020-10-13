package com.sv.ecommerceapp.cartmicroservice.service;

import com.sv.ecommerceapp.cartmicroservice.model.Cart;

import java.util.List;

public interface CartService {

    public Cart createCart(List<Long> productIds);
    public Cart deleteCart(Long cartId);


}
