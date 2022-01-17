package br.com.delivery.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.delivery.enums.MenuType;
import br.com.delivery.models.Menu;

public class MenuProductForm {
	
	@NotNull(message = "Produto não pode ser vazio.")
	private Long productId;

	@NotEmpty(message = "Tipo não pode ser vazio.")
	private String type;

	public Menu toMenu() {
		var menu = new Menu();
		menu.setType(MenuType.valueOf(type));
		return menu;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
