package com.sv.ecommerceapp.orders.ordersmicroservice.service;

import com.sv.ecommerceapp.orders.ordersmicroservice.exception.NoOrderFoundException;
import com.sv.ecommerceapp.orders.ordersmicroservice.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public Optional<Order> retrieveByOrderID(int orderId);
    public String createDefaultOrder();

    public Order createOrder();
    public Order updateOrder(Order order);
    public Order deleteOrder(int orderId);


    public Order updateOrderStatus(Order order);

    public List<Order> getAllOrders();

    public List<Order> getOrdersByStatus(String status) throws NoOrderFoundException;
}
