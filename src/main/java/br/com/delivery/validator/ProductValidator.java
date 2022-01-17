package br.com.delivery.validator;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.exception.InvalidException;
import br.com.delivery.models.Menu;
import br.com.delivery.repository.MenuRepository;
import br.com.delivery.repository.ProductRepository;

@Service
public class ProductValidator {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private MenuRepository menuRepository;

	public void validate(Long id, Menu menu) {
		var product = productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Produto não encontrado para os dados informados."));
		menuRepository.findByProduct(product).ifPresent(menuP -> {
			throw new InvalidException("Produto: '" + menuP.getProduct().getName() + "', já foi incluído ao cardápio.");
		});
		menu.setProduct(product);

	}
}
