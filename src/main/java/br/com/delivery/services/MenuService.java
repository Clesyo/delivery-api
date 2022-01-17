package br.com.delivery.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.dtos.MenuDto;
import br.com.delivery.forms.MenuForm;
import br.com.delivery.interfaces.IMenuService;
import br.com.delivery.repository.MenuRepository;
import br.com.delivery.validator.ProductValidator;

@Service
public class MenuService implements IMenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private ProductValidator productValidator;

	@Override
	public MenuDto save(@Valid MenuForm form) {
		var menus = form.getProducts().stream().map(product -> {
			var menu = product.toMenu();
			productValidator.validate(product.getProductId(), menu);
			return menu;
		}).toList();
		menus = menuRepository.saveAll(menus);
		return MenuDto.buildMenu(menus);
	}

	@Override
	public MenuDto menu() {
		var menus = menuRepository.findAll();
		return MenuDto.buildMenu(menus);
	}

}
