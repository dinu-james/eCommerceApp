package com.sv.ecommerceapp.orders.ordersmicroservice.service;

import com.sv.ecommerceapp.orders.ordersmicroservice.exception.NoOrderFoundException;
import com.sv.ecommerceapp.orders.ordersmicroservice.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public Optional<Order> retrieveByOrderID(int orderId);
    public void createHardCodedOrder();

    public void createOrder(Order order);
    public void updateOrder(Order order);
    public void deleteOrder(int orderId);


    public void updateOrderStatus(Order order);

    public List<Order> getAllOrders();

    public List<Order> getOrdersByStatus(String status) throws NoOrderFoundException;
}
