package com.payment.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.paymentservice.model.PaymentEntity;

public interface PaymentRepository extends JpaRepository<Integer, PaymentEntity> {

	//
}
