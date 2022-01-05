package br.com.delivery.dtos;

import br.com.delivery.models.Category;

public class CategoryDto {

	private String name;

	public CategoryDto(Category category) {
		this.name = category.getName();
	}

	public static CategoryDto convert(Category category) {
		return new CategoryDto(category);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
