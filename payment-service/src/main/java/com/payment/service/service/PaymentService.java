package com.payment.service.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.payment.service.model.PaymentEntity;

@Service
public interface PaymentService {

	// pay, getPaymentFor, //generateRecieptFor

	public String pay();

	public PaymentEntity generateReciept();
	
	public String checkForFallback();
}
