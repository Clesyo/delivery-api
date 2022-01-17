package br.com.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.http.HttpStatus.*;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.delivery.dtos.MenuDto;
import br.com.delivery.forms.MenuForm;
import br.com.delivery.interfaces.IMenuService;

@RestController
@RequestMapping(path = "/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuController {

	@Autowired
	private IMenuService menuService;
	
	@PostMapping
	@ResponseStatus(CREATED)
	public MenuDto generate(@RequestBody @Valid MenuForm form) {
		return menuService.save(form);
	}
	
	@GetMapping
	@ResponseStatus(OK)
	public MenuDto menu() {
		return menuService.menu();
	}
}
