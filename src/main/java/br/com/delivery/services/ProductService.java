package br.com.delivery.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.dtos.ProductDto;
import br.com.delivery.forms.ProductForm;
import br.com.delivery.interfaces.IProductService;
import br.com.delivery.repository.CategoryRepository;
import br.com.delivery.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public ProductDto save(ProductForm form) {
		// TODO Auto-generated method stub
		var category = categoryRepository.findById(form.getCategoryId())
				.orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada para os dados informados."));
		var product = form.toProduct();
		product.setCategory(category);
		product = productRepository.save(product);
		return ProductDto.convert(product);
	}

}
