package br.com.delivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.models.Client;
import br.com.delivery.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	Optional<Order> findByIdAndClient(Long id, Client client);
}
