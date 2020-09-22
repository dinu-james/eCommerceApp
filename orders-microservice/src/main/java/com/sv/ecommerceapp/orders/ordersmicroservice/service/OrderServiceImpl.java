package com.sv.ecommerceapp.orders.ordersmicroservice.service;

import com.sv.ecommerceapp.orders.ordersmicroservice.model.Order;
import com.sv.ecommerceapp.orders.ordersmicroservice.repositry.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Optional<Order> retrieveByOrderID(int orderId) {

        return orderRepository.findById(orderId);
    }

    @Override
    public void createOrder() {
        Order order = new Order();
        order.setOrderId(123);
        order.setCustomerId("ABCD");
        order.setStatus("PENDING");
        order.setOrderDate(LocalDate.now());
        orderRepository.save(order);
    }
}
