package br.com.delivery.interfaces;

import br.com.delivery.dtos.CategoryDto;
import br.com.delivery.forms.CategoryForm;

public interface ICategoryService {

	CategoryDto save(CategoryForm form);
}
