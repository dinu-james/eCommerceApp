package com.sv.ecommerceapp.cartmicroservice.service;

import com.sv.ecommerceapp.cartmicroservice.model.Cart;
import com.sv.ecommerceapp.cartmicroservice.model.Item;

import java.util.List;

public interface CartService {

	public Cart addItemToCart(Long productId, Integer quantity);

	Cart retrieveCart();

	void clearCart();

	void removeItem(Long productId);
}
