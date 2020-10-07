package com.sv.ecommerceapp.orders.ordersmicroservice.controller;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sv.ecommerceapp.orders.ordersmicroservice.model.Item;

@FeignClient(name = "zuul-api-server")
@RibbonClient(name= "catalogue-service")
public interface OrderProxy {

	
	@GetMapping(value = "catalogue-service/name/{productId}")
    public Item getOneProductById (@PathVariable("productId") Long productId);

	
	@GetMapping(value = "catalogue-service/p1/products/getAllProduct")
    public List<Item> getAllProducts();
}
