package com.payment.service.proxy;

import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.payment.service.model.Order;


@FeignClient(name = "zuul-api-server")
@RibbonClient(name = "orders-service")
public interface OrderProxy {

	@RequestMapping(value = "/orders-service/orders/retrieveOrderId", method = RequestMethod.GET)
	public int retrieveOrderId();

	
	 @RequestMapping(value = "/orders-service/orders/retrieve/{orderId}",method=RequestMethod.GET)
    public ResponseEntity<Optional<Order>> retrieveByOrderID(@PathVariable("orderId") int orderId );
}
