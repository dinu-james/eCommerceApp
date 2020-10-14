package com.sv.ecommerceapp.cartmicroservice.repository;

import com.sv.ecommerceapp.cartmicroservice.model.Cart;
import com.sv.ecommerceapp.cartmicroservice.model.Item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart,Long> {

    //@Query("SELECT o from Cart c where c.cartId = :cartId")
    void deleteById(Long cartId);

	void addItemToCart(Long cartId, Item item);

	List<Object> getCart(Long cartId, Class<Item> class1);

	void deleteItemFromCart(Long cartId, Item item);
    
}
