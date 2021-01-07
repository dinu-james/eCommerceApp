package com.payment.service.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.payment.service.model.ModeOfPayment;
import com.payment.service.model.PaymentEntity;
import com.payment.service.model.TransactionId;
import com.payment.service.proxy.OrderProxy;
import com.payment.service.repository.PaymentRepository;

@Component
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	OrderProxy orderProxy;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Override
	@Transactional
	public String pay() {
		
		PaymentEntity paymentEntity = new PaymentEntity();
		TransactionId txId= new TransactionId();
		int orderId = orderProxy.retrieveOrderId();
		BigDecimal totalAmount = orderProxy.retrieveByOrderID(orderId).getBody().get().getTotalAmount();
		paymentEntity.setOrderID(orderId);
		paymentEntity.setTotalAmount(totalAmount);
		paymentEntity.setTxnId(txId);
		paymentEntity.setStatus("successful");
		paymentEntity.setMop(ModeOfPayment.valueOf("COD"));
		paymentEntity.setIsRollback(false);
		paymentEntity.setTimeStamp(LocalDate.now());
		paymentEntity.setReason("OK");
		paymentRepository.save(paymentEntity);
		
		return "payment successfully completed";
	}

	@Override
	public PaymentEntity generateReciept() {
		List<PaymentEntity> payments = paymentRepository.findAll();
		System.out.println(payments.get(0).getTxnId());
		return payments.get(0);
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "defaultResponse", 
			commandProperties = {@HystrixProperty (name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
	public String checkForFallback() {
		int i = (int) (Math.random() * 10);
		if(i%2 == 0) 
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Method running Fine!" + i;
		}
		else {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Going for Fallback!";
		}
	}
	
	public String defaultResponse() {
		return "Inside Fallback Method";
	}
}
