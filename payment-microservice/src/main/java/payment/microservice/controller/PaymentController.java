package payment.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import payment.microservice.model.Order;
import payment.microservice.proxy.OrderProxy;
import payment.microservice.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	// paymentStatus(), initiatePayment(),generateReciept(),
//	@Autowired
//	PaymentService paymentService;
	
	
	@Autowired
	OrderProxy orderProxy;

	@RequestMapping(method = RequestMethod.GET, value = "/initiatePayment")
	public void initiatePayment() {
//		String result = resttemplate.getForObject("http://localhost:8080/orders/status/test", String.class);
//		System.out.println("==================================="+result);
//		HttpEntity<Order> request = new HttpEntity<>(new Order());
//		
//		ResponseEntity<Order> order = resttemplate.postForEntity("http://localhost:8080/orders/createOrder", request, Order.class);
//		System.out.println("==================================="+order.getBody().getOrderId());
		int orderId = orderProxy.retrieveOrderID();
		System.out.println("=========================="+orderId);
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
