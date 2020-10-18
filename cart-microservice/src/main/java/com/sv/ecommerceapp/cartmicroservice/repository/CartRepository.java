package com.sv.ecommerceapp.cartmicroservice.repository;

import com.sv.ecommerceapp.cartmicroservice.model.Cart;
import com.sv.ecommerceapp.cartmicroservice.model.Item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    
}
