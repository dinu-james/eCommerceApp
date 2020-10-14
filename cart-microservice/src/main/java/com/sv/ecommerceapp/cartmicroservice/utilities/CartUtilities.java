package com.sv.ecommerceapp.cartmicroservice.utilities;

import com.sv.ecommerceapp.cartmicroservice.model.Item;

import java.math.BigDecimal;

public class CartUtilities {

    public static BigDecimal getSubTotalForItem(Item item, int quantity){
       return item.getPrice().getValue().multiply(BigDecimal.valueOf(quantity));
    }
}
