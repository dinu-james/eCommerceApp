package com.sv.ecommerceapp.orders.ordersmicroservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@Column(name = "ORDER_STATUS")
	private String status;

	@Column(name = "ORDER_DATE")
	private LocalDate orderDate;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Item> items = new HashSet<Item>();

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", status=" + status + ", orderDate=" + orderDate + ", items=" + items
				+ "]";
	}

}
