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
	
	
//	@RequestMapping(value = PaymentLinks.PAYMENT, method = PUT)
//	ResponseEntity<PaymentResource> submitPayment(@PathVariable("id") Order order,
//			@RequestBody CreditCardNumber number) {
//
//		if (order == null || order.isPaid()) {
//			return new ResponseEntity<PaymentResource>(HttpStatus.NOT_FOUND);
//		}
//
//		CreditCardPayment payment = paymentService.pay(order, number);
//
//		PaymentResource resource = new PaymentResource(order.getPrice(), payment.getCreditCard());
//		resource.add(entityLinks.linkToSingleResource(order));
//
//		return new ResponseEntity<PaymentResource>(resource, HttpStatus.CREATED);
//	}

}
