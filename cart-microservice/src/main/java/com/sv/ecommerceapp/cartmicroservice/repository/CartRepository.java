package com.sv.ecommerceapp.cartmicroservice.repository;

import com.sv.ecommerceapp.cartmicroservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    @Query("SELECT o from Cart c where c.cartId = :cartId")
    Cart deleteCartById(@Param("cartId") Long cartId);
}
