package com.sv.ecommerceapp.orders.ordersmicroservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "catalogue-microservice", url = "localhost:8000/p1/products")
public interface OrderProxy {

	
	@GetMapping(value = "/name/{productId}")
    public String getProductNameById (@PathVariable("productId") Long productId);

}
