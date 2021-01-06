package com.payment.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payment.service.proxy.OrderProxy;
import com.payment.service.service.PaymentService;
import com.payment.service.service.PaymentServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	// paymentStatus(), initiatePayment(),generateReciept(),
//		@Autowired
//		PaymentService paymentService;
		
		
		@Autowired
		PaymentService paymentService;

		
		@ApiOperation("initiates  payment method once the order is placed")
		@RequestMapping(method = RequestMethod.POST, value = "/initiatePayment")
		public void initiatePayment() {
//			String result = resttemplate.getForObject("http://localhost:8080/orders/status/test", String.class);
//			System.out.println("==================================="+result);
//			HttpEntity<Order> request = new HttpEntity<>(new Order());
//			//		ResponseEntity<Order> order = resttemplate.postForEntity("http://localhost:8080/orders/createOrder", request, Order.class);
//			System.out.println("==================================="+order.getBody().getOrderId());
			
			
			System.out.println(paymentService.pay());
		}	
//	
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
//		resource.add(en
//			//		resource.add(entityLinks.linkToSingleResource(order));
//
//		return new ResponseEntity<PaymentResource>(resource, HttpStatus.CREATED);
//	}
}
