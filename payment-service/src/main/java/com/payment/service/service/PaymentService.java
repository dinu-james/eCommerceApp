package com.payment.service.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

	// pay, getPaymentFor, //generateRecieptFor

	public String pay();

	public String generateReciept();
}
