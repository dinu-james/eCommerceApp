package com.sv.ecommerceapp.orders.ordersmicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @Column(name="ORDER_ID")
    private int orderId;
    @Column(name="ORDER_STATUS")
    private String status;

    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column(name="ORDER_DATE")
    private LocalDate orderDate;

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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", status='" + status + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
