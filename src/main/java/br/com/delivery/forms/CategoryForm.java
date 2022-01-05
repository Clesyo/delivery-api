package br.com.delivery.forms;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;

import br.com.delivery.models.Category;

public class CategoryForm {

	@NotBlank(message = "Nome não pode ser vazio.")
	private String name;

	public Category toCategory(Category... categories) {
		var category = new Category();
		var list = Arrays.asList(categories);

		if (!list.isEmpty())
			category = list.get(0);

		category.setName(name);
		return category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
