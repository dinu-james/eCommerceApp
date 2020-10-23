package com.sv.ecommerceapp.orders.ordersmicroservice.proxy;

import com.sv.ecommerceapp.orders.ordersmicroservice.model.Cart;
import com.sv.ecommerceapp.orders.ordersmicroservice.model.Item;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zuul-api-server")
@RibbonClient(name= "cart-service")
public interface CartProxy {

    @GetMapping(value = "/cart-service/cart/retrieveCart")
    public Cart getAllProductsFromCart ();

    @DeleteMapping(value = "/cart-service/cart/clearCart")
    public String clearCart ();
}
