package com.sv.ecommerceapp.orders.ordersmicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

	@ManyToMany
	@JoinTable(name = "orders_items", joinColumns = {
            @JoinColumn(name = "order_id", referencedColumnName = "order_id") }, inverseJoinColumns = {
            @JoinColumn(name = "id", referencedColumnName = "id") })
	private List<Item> items = new ArrayList<Item>();
	
	

	public Order(List<Item> items) {
		super();
		this.items = items;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", status=" + status + ", orderDate=" + orderDate + ", items=" + items
				+ "]";
	}

}
