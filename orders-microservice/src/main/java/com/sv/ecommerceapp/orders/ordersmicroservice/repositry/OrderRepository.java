package com.sv.ecommerceapp.orders.ordersmicroservice.repositry;

import com.sv.ecommerceapp.orders.ordersmicroservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Override
    Optional<Order> findById(Integer orderId);

    @Override
    List<Order> findAll();

    List<Order> findByStatus(String status);
    
    @Query("SELECT o from Order o where o.orderId = :orderId")
    Order deleteOrderById(@Param("orderId") Integer orderId);

}
