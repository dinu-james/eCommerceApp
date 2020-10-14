package com.sv.ecommerceapp.cartmicroservice.model;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
	/***
	 * either remove the id field completely
	 * or hardcode - preferred
	 */
    @Id
    @Column(name = "CART_ID")
    private long cartId;

   // @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemId", referencedColumnName = "id")
    private Item item;

    //can be calculated as monetary*quantity, summation for all products
    @Column(name = "TOTAL_AMT")
    private BigDecimal totalAmount;
    
    public Cart(Item item,  BigDecimal totalAmount) {
		super();
		this.item = item;
		this.totalAmount = totalAmount;
	}

	

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

	/*
	 * public List<Item> getItems() { return items; }
	 * 
	 * public void setItems(List<Item> items) { this.items = items; }
	 * 
	    public void addItems(Item i) {
        if (i != null) {
            if (items != null) {
                items = new ArrayList<>();
            }
            i.setCart(this);
            items.add(i);
        }
    }*/
}
