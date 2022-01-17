package br.com.delivery.dtos;

import java.math.BigDecimal;

import br.com.delivery.models.Product;

public class MenuProductDto {

	private String product;

	private String description;

	private BigDecimal price;

	private String category;

	public MenuProductDto(Product product) {
		super();
		this.product = product.getName();
		this.price = product.getPrice();
		this.category = product.getCategory().getName();
		this.description = product.getDescription();
	}

	public static MenuProductDto convert(Product product) {
		return new MenuProductDto(product);
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
