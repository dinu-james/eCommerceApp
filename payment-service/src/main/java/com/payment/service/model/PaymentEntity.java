package com.payment.service.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String status;
	private Boolean isRollback;
	private String reason;

	private int orderID;

	BigDecimal totalAmount;

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Embedded
	private TransactionId txnId;

	private LocalDate timeStamp;
	ModeOfPayment mop;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIsRollback() {
		return isRollback;
	}

	public void setIsRollback(Boolean isRollback) {
		this.isRollback = isRollback;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getTxnId() {
		return txnId.toString();
	}

	public void setTxnId(TransactionId txnId) {
		this.txnId = txnId;
	}

	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}

	public ModeOfPayment getMop() {
		return mop;
	}

	public void setMop(ModeOfPayment mop) {
		this.mop = mop;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	@Override
	public String toString() {
		return "PaymentEntity [id=" + id + ", status=" + status + ", isRollback=" + isRollback + ", reason=" + reason
				+ ", orderID=" + orderID + ", totalAmount=" + totalAmount + ", txnId=" + txnId.toString() + ", timeStamp="
				+ timeStamp + ", mop=" + mop + "]";
	}
}
