package com.sv.ecommerceapp.orders.ordersmicroservice.controller;

import com.sv.ecommerceapp.orders.ordersmicroservice.config.Configuration;
import com.sv.ecommerceapp.orders.ordersmicroservice.exception.BadRequest;
import com.sv.ecommerceapp.orders.ordersmicroservice.exception.NoOrderFoundException;
import com.sv.ecommerceapp.orders.ordersmicroservice.exception.NoSuchDataFoundException;
import com.sv.ecommerceapp.orders.ordersmicroservice.model.Order;
import com.sv.ecommerceapp.orders.ordersmicroservice.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
 
    
    @Value("${message}")
    String message;
 

    @RequestMapping("/status/test")
    public String test(){
    	
        return "Orders-microservice is up !"+message+" ";
    }


    @ApiOperation("Retrieve order by order ID")
    @RequestMapping(value = "retrieve/{orderId}",method=RequestMethod.GET)
    public ResponseEntity<Optional<Order>> retrieveByOrderID(@PathVariable("orderId") int orderId ){
    	Optional<Order> order= Optional.empty();
    	order = orderService.retrieveByOrderID(orderId);
    	if(!order.isPresent()) throw new NoOrderFoundException("No order with Order Id : "+orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @ApiOperation("Create a default order")
    @RequestMapping(value ="/createDefault",method=RequestMethod.GET)
    public ResponseEntity<String> createDefaultOrder(){
         String or = orderService.createDefaultOrder();
         return new ResponseEntity<>(or,HttpStatus.OK);
    }

    @ApiOperation("Create an  order with all items from cart")
    @RequestMapping(value ="/createOrder",method=RequestMethod.POST)
    public ResponseEntity<Order> createOrder(){
    	Order or = orderService.createOrder();
    	if(or == null) throw new BadRequest("Order not created");
    	return new ResponseEntity<>(or,HttpStatus.OK);
    }

    @ApiOperation("Update an  order")
    @RequestMapping(value ="/updateOrder",method=RequestMethod.POST)
    public ResponseEntity<Order> update(@RequestBody Order order){
    	Order or = orderService.updateOrder(order);
    	if(or == null) throw new BadRequest("Order not updated");
    	return new ResponseEntity<>(or,HttpStatus.OK);
    }

    @ApiOperation("Update an order's delivery status")
    @RequestMapping(value ="/updateOrderStatus",method=RequestMethod.POST)
    public ResponseEntity<Order> updateOrderStatus(@RequestBody Order order){
    	Order or = orderService.updateOrderStatus(order);
    	if(or == null) throw new BadRequest("Order status not updated");
    	return new ResponseEntity<>(or,HttpStatus.OK);
    }

    @ApiOperation("Delete an order")
    @RequestMapping(value ="/deleteOrder/{orderId}",method=RequestMethod.DELETE)
    public ResponseEntity<Order> deleteOrders(@PathVariable("orderId") int orderId){
    	Order order = orderService.deleteOrder(orderId);
    	if(order == null) throw new NoOrderFoundException("No order found, to delete, with order id : "+orderId); 
    	return new ResponseEntity<>(order, HttpStatus.OK);
        
    }

    @ApiOperation("Retrieve all orders")
    @RequestMapping(value ="/getAllOrders",method=RequestMethod.GET)
    public ResponseEntity<List<Order>> getAllOrders(){
    	List<Order> orders = orderService.getAllOrders();
    	if(null == orders || orders.isEmpty()) throw new NoOrderFoundException();
    	return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @ApiOperation("Retrieve all orders with a particular status")
    @RequestMapping(value ="/getOrdersByStatus/{status}",method=RequestMethod.GET)
    public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable("status") String status) throws NoOrderFoundException {
        List<Order> list =  orderService.getOrdersByStatus(status);
        if(list == null || list.isEmpty()) throw new NoSuchDataFoundException("No order with status as : "+status);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
