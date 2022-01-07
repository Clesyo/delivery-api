package br.com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
