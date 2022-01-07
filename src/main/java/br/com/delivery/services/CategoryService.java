package br.com.delivery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.dtos.CategoryDto;
import br.com.delivery.exception.InvalidException;
import br.com.delivery.forms.CategoryForm;
import br.com.delivery.interfaces.ICategoryService;
import br.com.delivery.repository.CategoryRepository;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryDto save(CategoryForm form) {
		// TODO Auto-generated method stub
		categoryRepository.findByName(form.getName()).ifPresent(category -> {
			throw new InvalidException("Já existe uma categoria com o mesma descrição.");
		});
		var category = form.toCategory();
		category = categoryRepository.save(category);
		return CategoryDto.convert(category);
	}

}
