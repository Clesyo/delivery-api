package br.com.delivery.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.model.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
