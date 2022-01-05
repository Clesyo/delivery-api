package br.com.delivery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.delivery.dtos.CategoryDto;
import br.com.delivery.forms.CategoryForm;
import br.com.delivery.interfaces.ICategoryService;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;

	@PostMapping
	@ResponseStatus(code = CREATED)
	public CategoryDto save(@RequestBody @Valid CategoryForm form) {
		return categoryService.save(form);
	}
}
