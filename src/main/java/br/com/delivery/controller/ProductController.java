package br.com.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.*;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.delivery.dtos.ProductDto;
import br.com.delivery.forms.ProductForm;
import br.com.delivery.interfaces.IProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@PostMapping
	@ResponseStatus(code = CREATED)
	public ProductDto save(@RequestBody @Valid ProductForm form) {
		return productService.save(form);
	}
}
