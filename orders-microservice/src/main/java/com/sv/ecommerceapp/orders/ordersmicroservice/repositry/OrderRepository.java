package com.sv.ecommerceapp.orders.ordersmicroservice.repositry;

import com.sv.ecommerceapp.orders.ordersmicroservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order,Integer> {

    @Override
    Optional<Order> findById(Integer orderId);

    @Override
    List<Order> findAll();

    List<Order> findByStatus(String status);

}
