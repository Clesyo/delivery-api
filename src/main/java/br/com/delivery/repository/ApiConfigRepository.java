package br.com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.models.ApiConfig;

public interface ApiConfigRepository extends JpaRepository<ApiConfig, Long>{

}
