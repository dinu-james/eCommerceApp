package com.sv.ecommerceapp.orders.ordersmicroservice.service;

import com.sv.ecommerceapp.orders.ordersmicroservice.exception.NoOrderFoundException;
import com.sv.ecommerceapp.orders.ordersmicroservice.model.Order;
import com.sv.ecommerceapp.orders.ordersmicroservice.repositry.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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
    public List<Order> getAllOrders() {
        List<Order> ordersList =orderRepository.findAll();
       return ordersList;
    }

    @Override
    public List<Order> getOrdersByStatus(String status) throws NoOrderFoundException {
        List<Order> ordersList =orderRepository.findByStatus(status);
        if(ordersList.isEmpty()){
            throw new NoOrderFoundException();
        }
        return ordersList;
               // Optional.ofNullable(ordersList).orElseThrow(() -> new NoOrderFoundException("No Order Found"));
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
