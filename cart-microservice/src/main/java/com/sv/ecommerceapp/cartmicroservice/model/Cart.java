package com.sv.ecommerceapp.cartmicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @Column(name = "CART_ID")
    private long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("items")
    private List<Item> items;


    @Column(name = "TOTAL_AMT")
    private BigDecimal totalAmount;
    
    public Cart(BigDecimal totalAmount,Long cartId) {
		super();
        this.cartId = cartId;
		this.totalAmount = totalAmount;
	}

    public Cart() {

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

	public List<Item> getItems() { return items; }

    public void setItems(List<Item> items) { this.items = items; }

	    public void addItems(Item i) {
        if (i != null) {
            if (items == null) {
                items = new ArrayList<>();
            }
            i.setCart(this);
            items.add(i);
        }
    }
}
