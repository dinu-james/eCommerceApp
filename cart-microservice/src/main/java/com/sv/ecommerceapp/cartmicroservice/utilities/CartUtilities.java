package com.sv.ecommerceapp.cartmicroservice.utilities;

import com.sv.ecommerceapp.cartmicroservice.model.Cart;
import com.sv.ecommerceapp.cartmicroservice.model.Item;

import java.math.BigDecimal;

public class CartUtilities {

    public static BigDecimal getSubTotalForItem(Item item){
       return item.getPrice().getValue().multiply(BigDecimal.valueOf(item.getQuantity()));
    }

    public static BigDecimal getTotalForCart(Cart cart){
        BigDecimal[] total ={BigDecimal.ZERO};
        cart.getItems().forEach(item->{
            total[0]=total[0].add(getSubTotalForItem(item));
        });
        return total[0];
    }
}
