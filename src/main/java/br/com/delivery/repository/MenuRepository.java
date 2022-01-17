package br.com.delivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.models.Menu;
import br.com.delivery.models.Product;

public interface MenuRepository extends JpaRepository<Menu, Long>{

	Optional<Menu> findByProduct(Product product);
}
