package br.com.delivery.forms;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.delivery.enums.ProductType;
import br.com.delivery.models.Product;

public class ProductForm {

	@NotBlank(message = "Nome não pode ser vazio.")
	private String name;

	private String description;

	@NotNull(message = "Preço não pode ser vazio.")
	private BigDecimal price;

	@NotBlank(message = "Tipo não pode ser vazio.")
	private String type;

	@NotNull(message = "CategoriId não pode ser vazio.")
	private Long categoryId;

	public Product toProduct(Product... products) {
		var product = new Product();

		var list = Arrays.asList(products);
		if (!list.isEmpty())
			product = list.get(0);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setType(ProductType.valueOf(type));
		return product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
