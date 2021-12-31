package br.com.delivery.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
