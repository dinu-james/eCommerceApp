package com.sv.ecommerceapp.orders.ordersmicroservice.controller;

import com.sv.ecommerceapp.orders.ordersmicroservice.exception.BadRequest;
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
    
  /*  @Autowired
    CatalogueProxy catalogueProxy;*/

    @RequestMapping("/status/test")
    public String test(){
        return "Orders-microservice is up !";
    }

    
    @RequestMapping(value = "retrieve/{orderId}",method=RequestMethod.GET)
    public ResponseEntity<Optional<Order>> retrieveByOrderID(@PathVariable("orderId") int orderId ){
//    	String name = orderProxy.getProductNameById(productId);
//    	System.out.println("====================================="+name);
    	
    	Optional<Order> order= Optional.empty();
    	
    	order = orderService.retrieveByOrderID(orderId);
//    	order.get().set(name);
    	if(!order.isPresent()) throw new NoOrderFoundException("No order with Order Id : "+orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    
    @RequestMapping(value ="/createDefault",method=RequestMethod.GET)
    public ResponseEntity<String> createDefaultOrder(){
         String or = orderService.createDefaultOrder();
//         if(or == null) throw new BadRequest("Order not created");
         return new ResponseEntity<>(or,HttpStatus.OK);
    }

    @RequestMapping(value ="/createOrder",method=RequestMethod.POST)
    public ResponseEntity<Order> createOrder(){
    	Order or = orderService.createOrder();
    	if(or == null) throw new BadRequest("Order not created");
    	return new ResponseEntity<>(or,HttpStatus.OK);
    }

    @RequestMapping(value ="/updateOrder",method=RequestMethod.POST)
    public ResponseEntity<Order> update(@RequestBody Order order){
    	Order or = orderService.updateOrder(order);
    	if(or == null) throw new BadRequest("Order not updated");
    	return new ResponseEntity<>(or,HttpStatus.OK);
    }

    @RequestMapping(value ="/updateOrderStatus",method=RequestMethod.POST)
    public ResponseEntity<Order> updateOrderStatus(@RequestBody Order order){
    	Order or = orderService.updateOrderStatus(order);
    	if(or == null) throw new BadRequest("Order status not updated");
    	return new ResponseEntity<>(or,HttpStatus.OK);
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
