package br.com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.models.LogOrder;

public interface LogOrderRepository extends JpaRepository<LogOrder, Long>{

}
