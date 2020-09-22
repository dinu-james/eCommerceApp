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
    public void createHardCodedOrder() {
        Order order = new Order();
        order.setOrderId(123);
        order.setCustomerId("ABCD");
        order.setStatus("PENDING");
        order.setOrderDate(LocalDate.now());
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(Order order) {
       orderRepository.save(order);
    }

    @Override
    public void updateOrderStatus(Order order) {
        Optional<Order> or=  orderRepository.findById(order.getOrderId());
        or.get().setStatus(order.getStatus());
        orderRepository.save(or.get());
    }

    @Override
    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }
}
