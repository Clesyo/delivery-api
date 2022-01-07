package br.com.delivery.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
