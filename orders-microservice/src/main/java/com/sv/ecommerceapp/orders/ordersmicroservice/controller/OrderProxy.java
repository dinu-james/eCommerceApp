package com.sv.ecommerceapp.orders.ordersmicroservice.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sv.ecommerceapp.orders.ordersmicroservice.model.Item;

@FeignClient(value = "catalogue-microservice", url = "localhost:8000/p1/products")
public interface OrderProxy {

	
	@GetMapping(value = "/name/{productId}")
    public Item getOneProductById (@PathVariable("productId") Long productId);

	
	@GetMapping(value = "/getAllProduct")
    public List<Item> getAllProducts();
}
