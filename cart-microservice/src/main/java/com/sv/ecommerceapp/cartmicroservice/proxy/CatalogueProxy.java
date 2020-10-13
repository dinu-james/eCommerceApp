package com.sv.ecommerceapp.cartmicroservice.proxy;

import com.sv.ecommerceapp.cartmicroservice.model.Item;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "zuul-api-server")
@RibbonClient(name= "catalogue-service")
public interface CatalogueProxy {

        @GetMapping(value = "/catalogue-service/p1/products/name/{productId}")
        public Item getOneProductById (@PathVariable("productId") Long productId);

        @GetMapping(value = "/catalogue-service/p1/products/getAllProduct")
        public List<Item> getAllProducts();

        //This method needs to be implemented in catalogue side - NOT YET IMPLEMENTED - or else use getOneProductById and iterate through each id
        @PostMapping(value = "/catalogue-service/p1/products/getProductsByProductIds")
        public List<Item> getProductsByProductIds(List<Long> productIds);

}
