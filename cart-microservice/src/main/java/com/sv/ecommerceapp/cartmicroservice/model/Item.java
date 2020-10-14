package com.sv.ecommerceapp.cartmicroservice.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Item {

	private String name;
	private int quantity;
	@Embedded
	private MonetaryAmount price;
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@OneToOne(mappedBy = "item")
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

	/*
	 * public Order getOrder() { return order; }
	 * 
	 * public void setOrder(Order order) { this.order = order; }
	 */
	
//	public void addOrderId(Order order) {
//		order.setItems((List<Item>) this);
//		order.se
//		
//	}

}
