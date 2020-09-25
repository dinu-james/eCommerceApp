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

    @RequestMapping("/status/test")
    public String test(){
        return "Orders-microservice is up !";
    }

    @RequestMapping(value = "retrieve/{orderId}",method=RequestMethod.GET)
    public Optional<Order> retrieveByOrderID(@PathVariable("orderId") int orderId){
        return orderService.retrieveByOrderID(orderId);
    }

    @RequestMapping(value ="/createDefault",method=RequestMethod.POST)
    public String createHardCodedOrder(Order order){
         orderService.createHardCodedOrder();
         return "Default order created!";
    }

    @RequestMapping(value ="/createOrder",method=RequestMethod.POST)
    public String createOrder(@RequestBody Order order){
    orderService.createOrder(order);
        return "Order Created";
    }

    @RequestMapping(value ="/updateOrder",method=RequestMethod.POST)
    public String update(@RequestBody Order order){
        orderService.updateOrder(order);
        return "Order Updated";
    }

    @RequestMapping(value ="/updateOrderStatus",method=RequestMethod.POST)
    public String updateOrderStatus(@RequestBody Order order){
        orderService.updateOrderStatus(order);
        return "Order Updated";
    }

    @RequestMapping(value ="/deleteOrder/{orderId}",method=RequestMethod.DELETE)
    public ResponseEntity<Order> deleteOrders(@PathVariable("orderId") int orderId){
    	Order order = orderService.deleteOrder(orderId);
    	if(order == null) throw new NoOrderFoundException("No order found, to delete, with order id : "+orderId); 
    	return new ResponseEntity<>(order, HttpStatus.OK);
        
    }

    @RequestMapping(value ="/getAllOrders",method=RequestMethod.GET)
    public ResponseEntity<List<Order>> getAllOrders(){
    	List<Order> orders = orderService.getAllOrders();
    	if(null == orders || orders.isEmpty()) throw new NoOrderFoundException();
    	return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @RequestMapping(value ="/getOrdersByStatus/{status}",method=RequestMethod.GET)
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
