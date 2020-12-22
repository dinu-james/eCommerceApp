package com.payment.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payment.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	// paymentStatus(), initiatePayment(),generateReciept(),
	@Autowired
	PaymentService paymentService;

	@RequestMapping(method = RequestMethod.POST, value = "/initiatePayment")
	public void initiatePayment() {

	}

}
