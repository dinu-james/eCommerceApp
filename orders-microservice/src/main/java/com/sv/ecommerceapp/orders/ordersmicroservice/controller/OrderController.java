package com.sv.ecommerceapp.orders.ordersmicroservice.controller;

import com.sv.ecommerceapp.orders.ordersmicroservice.exception.NoOrderFoundException;
import com.sv.ecommerceapp.orders.ordersmicroservice.exception.NoSuchDataFoundException;
import com.sv.ecommerceapp.orders.ordersmicroservice.model.Order;
import com.sv.ecommerceapp.orders.ordersmicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/status/test")
    public String test(){
        return "Orders-microservice is up !";
    }

    @GetMapping("/retrieve/{orderId}")
    public Optional<Order> retrieveByOrderID(@PathVariable("orderId") int orderId){
        return orderService.retrieveByOrderID(orderId);
    }

    @GetMapping("/createDefault")
    public String createHardCodedOrder(Order order){
         orderService.createHardCodedOrder();
         return "Default order created!";
    }

    @PostMapping("/createOrder")
    public String createOrder(@RequestBody Order order){
        orderService.createOrder(order);
        return "Order Created";
    }

    @PostMapping("/updateOrder")
    public String update(@RequestBody Order order){
        orderService.updateOrder(order);
        return "Order Updated";
    }

    @PostMapping("/updateOrderStatus")
    public String updateOrderStatus(@RequestBody Order order){
        orderService.updateOrderStatus(order);
        return "Order Updated";
    }

    @GetMapping("/deleteOrder/{orderId}")
    public ResponseEntity<Order> deleteOrders(@PathVariable("orderId") int orderId){
    	Order order = orderService.deleteOrder(orderId);
    	if(order == null) throw new NoOrderFoundException("No order found, to delete, with order id : "+orderId); 
    	return new ResponseEntity<>(order, HttpStatus.OK);
        
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders(){
    	List<Order> orders = orderService.getAllOrders();
    	if(null == orders || orders.isEmpty()) throw new NoOrderFoundException();
    	return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/getOrdersByStatus/{status}")
    public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable("status") String status) throws NoOrderFoundException {
    	
        List<Order> list =  orderService.getOrdersByStatus(status);
        if(list == null || list.isEmpty()) throw new NoSuchDataFoundException("No order with status as : "+status);
       
		/*
		 * try { list = orderService.getOrdersByStatus(status); } catch
		 * (NoOrderFoundException e) { throw new NoOrderFoundException(); }
		 */
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
