package com.payment.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.service.model.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

	
}
