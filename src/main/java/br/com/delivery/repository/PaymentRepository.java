package br.com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
