package br.com.delivery.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.models.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
