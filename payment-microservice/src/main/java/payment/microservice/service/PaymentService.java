package payment.microservice.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

	//pay, getPaymentFor, //generateRecieptFor
	
	public String pay(BigDecimal totalAmount);
	
	public String generateReciept();
	
	
}