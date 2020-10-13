package com.sv.ecommerceapp.cartmicroservice.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @Column(name = "CART_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Item> items =  new ArrayList<Item>();;

    @Column(name = "TOTAL_AMT")
    private int totalAmount;

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItems(Item i) {
        if (i != null) {
            if (items != null) {
                items = new ArrayList<>();
            }
            i.setCart(this);
            items.add(i);
        }
    }
}
