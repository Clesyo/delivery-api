package br.com.delivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	Optional<Client> findByCpf(String cpf);
	Optional<Client> findByEmail(String email);
}
