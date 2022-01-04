package br.com.delivery.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	Optional<Client> findByCpf(String cpf);
}
