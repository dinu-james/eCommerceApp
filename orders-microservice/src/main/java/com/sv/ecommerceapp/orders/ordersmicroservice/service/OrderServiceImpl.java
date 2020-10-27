package com.sv.ecommerceapp.orders.ordersmicroservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sv.ecommerceapp.orders.ordersmicroservice.proxy.CartProxy;
import com.sv.ecommerceapp.orders.ordersmicroservice.exception.NoOrderFoundException;
import com.sv.ecommerceapp.orders.ordersmicroservice.model.Item;
import com.sv.ecommerceapp.orders.ordersmicroservice.model.MonetaryAmount;
import com.sv.ecommerceapp.orders.ordersmicroservice.model.Order;
import com.sv.ecommerceapp.orders.ordersmicroservice.repositry.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;


    @Autowired
    CartProxy cartProxy;


    @Override
    public Optional<Order> retrieveByOrderID(int orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
//    @HystrixCommand(fallbackMethod = "createDafaultResponse"
//    , commandProperties = {
//    		   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
    public String createDefaultOrder() {
//    	try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        Order order = new Order();
       Item item  = new Item();
        item.setId(1234L);
        item.setName("oneplus");
        item.setPrice(new MonetaryAmount(MonetaryAmount.EURO, 550.00));
        item.setQuantity(3);
        item.setVersion(8);
        Item item1  = new Item();
        item1.setId(1235L);
        item1.setName("Samsung fold");
        item1.setPrice(new MonetaryAmount(MonetaryAmount.EURO, 2000.00));
        item1.setQuantity(3);
        item1.setVersion(2);
        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        itemList.add(item1);
        order.setOrderId(12);
        order.setItems(itemList);
        order.setStatus("PENDING");
        order.setTotalAmount(BigDecimal.valueOf(1000));
        order.setOrderDateTime(LocalDateTime.now());
        orderRepository.save(order);
        return "Order created";
    }
    
//    public String createDafaultResponse() {
//		
//    	return "inside fallback method";
//    	
//    	
//    }

    @Override
    public Order updateOrder(Order order) {
       return orderRepository.save(order);
    }

    @Override
    public Order updateOrderStatus(Order order) {
        Optional<Order> or=  orderRepository.findById(order.getOrderId());
        or.get().setStatus(order.getStatus());
        Order o = orderRepository.save(or.get());
        return o;
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
    public Order deleteOrder(int orderId) {
        return orderRepository.deleteOrderById(orderId);
    }

    @Override
    @Transactional
    public Order createOrder() {
    	Order order = new Order();
    	order.setStatus("New");
    	order.setOrderDateTime(LocalDateTime.now());
        List<Item> items = cartProxy.getAllProductsFromCart().getItems();
        BigDecimal totalAmt = cartProxy.getAllProductsFromCart().getTotalAmount();
        order.setTotalAmount(totalAmt);
    	items.forEach(item-> order.addItems(item));
    	order.setItems(items);
        Order savedOrder = orderRepository.save(order);
        if(null != savedOrder){
            cartProxy.clearCart();
        }
        return savedOrder;
    }
}
