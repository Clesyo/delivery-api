package br.com.delivery.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
