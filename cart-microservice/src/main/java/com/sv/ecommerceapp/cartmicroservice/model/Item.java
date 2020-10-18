package com.sv.ecommerceapp.cartmicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import java.util.Objects;

@Entity
public class Item {

	@Id
	@Column(name = "id")
	private Long id;
	private String name;
	private int quantity;
	@Embedded
	private MonetaryAmount price;

	@ManyToOne
	@JoinColumn(name ="cart_id")
	@JsonIgnoreProperties("items")
	private Cart cart;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name ="order_id") private Order order;
	 */
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Item() {

	}

	public Item(String name, MonetaryAmount price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MonetaryAmount getPrice() {
		return price;
	}

	public void setPrice(MonetaryAmount price) {
		this.price = price;
	}

	public Cart getCart() {
		return cart;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Item item = (Item) o;
		return Objects.equals(id, item.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}


}
