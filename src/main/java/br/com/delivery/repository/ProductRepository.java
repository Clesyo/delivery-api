package br.com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
