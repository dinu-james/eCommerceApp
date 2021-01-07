package com.payment.service.model;

import java.time.Instant;

import javax.persistence.Embeddable;

@Embeddable
public class TransactionId {

	// alpha numeric
	// TX-ORDERID-ITEMIS-TIMESTAMP
	private String txId;

	public TransactionId() {
		super();
		Instant time = Instant.now();
		Long timeStamp = time.getEpochSecond();
		txId = "TX"+timeStamp;
	}

	@Override
	public String toString() {
		return txId;
	}

}