package br.com.delivery.interfaces;

import br.com.delivery.dtos.MenuDto;
import br.com.delivery.forms.MenuForm;

public interface IMenuService {

	MenuDto save(MenuForm form);
	MenuDto menu();
}
