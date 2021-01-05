package com.payment.service.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	public String generateReciept() {
		// TODO Auto-generated method stub

		return null;
	}
}
