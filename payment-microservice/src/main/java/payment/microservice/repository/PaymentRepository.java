package payment.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import payment.microservice.model.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

	//
}
