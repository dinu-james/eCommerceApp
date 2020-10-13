package com.sv.ecommerceapp.cartmicroservice.service;

import com.sv.ecommerceapp.cartmicroservice.model.Cart;
import com.sv.ecommerceapp.cartmicroservice.model.Item;
import com.sv.ecommerceapp.cartmicroservice.proxy.CatalogueProxy;
import com.sv.ecommerceapp.cartmicroservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {


    @Autowired
    CartRepository cartRepository;

    @Autowired
    CatalogueProxy catalogueProxy;


    @Override
    public Cart createCart(List<Long> productIds) {
        Cart cart = new Cart();

        //This method needs to be implemented in catalogue side - NOT YET IMPLEMENTED - or else use getOneProductById and iterate through each id
        List<Item> items = catalogueProxy.getProductsByProductIds(productIds);

        items.forEach(item-> cart.addItems(item));
        cart.setItems(items);

        //Implement  generateTotalAmountForCart method
        cart.setTotalAmount(generateTotalAmountForCart(items));

        return cartRepository.save(cart);
    }

    private int generateTotalAmountForCart(List<Item> items) {

        //Need to implement this method

        return 0;
    }

    @Override
    public Cart deleteCart(Long cartId) {
        return cartRepository.deleteCartById(cartId);
    }
}
