package com.sv.ecommerceapp.cartmicroservice.service;

//import com.sv.ecommerceapp.cartmicroservice.model.Cart;
import com.sv.ecommerceapp.cartmicroservice.model.Item;

import java.util.List;

public interface CartService {

	/*
	 * public Cart createCart(Long productIds); public void deleteCart(Long cartId);
	 * // 2 more apis here - getAllProducts, deleteOneProduct
	 */
	
	public void addItemToCart(Long cartId, Long productId, Integer quantity);

	public List<Object> getCart(Long cartId);

	public void changeItemQuantity(Long cartId, Long productId, Integer quantity);

	public void deleteItemFromCart(Long cartId, Long productId);

	public boolean checkIfItemIsExist(Long cartId, Long productId);

	public List<Item> getAllItemsFromCart(Long cartId);

	public void deleteCart(Long cartId);

}
