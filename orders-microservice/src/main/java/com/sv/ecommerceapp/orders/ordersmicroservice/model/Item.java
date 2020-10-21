package com.sv.ecommerceapp.orders.ordersmicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Item{

	private String name;
	private int quantity;
	@Embedded
	private MonetaryAmount price;
	@Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "ID")
	private int slno;


	@Column(name = "ITEM_ID")
	private Long id;

	@Version
	@Column(name = "version")
	private Integer version;
	@ManyToOne
	@JoinColumn(name ="order_id")
	@JsonIgnoreProperties("items")
	private Order order;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
//	public void addOrderId(Order order) {
//		order.setItems((List<Item>) this);
//		order.se
//		
//	}

}
