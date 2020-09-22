package com.sv.ecommerceapp.orders.ordersmicroservice.repositry;

import com.sv.ecommerceapp.orders.ordersmicroservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Override
    Optional<Order> findById(Integer orderId);


}
