package br.com.delivery.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
