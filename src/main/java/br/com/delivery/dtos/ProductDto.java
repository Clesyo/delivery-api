package br.com.delivery.dtos;

import java.math.BigDecimal;

import br.com.delivery.models.Product;

public class ProductDto {

	private String publicId;

	private String name;

	private String description;

	private BigDecimal price;

	private String type;

	private String category;

	public ProductDto(Product product) {
		this.publicId = product.getPublicId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.type = product.getType().name();
		this.category = product.getCategory().getName();
	}

	public static ProductDto convert(Product product) {
		return new ProductDto(product);
	}

	public String getPublicId() {
		return publicId;
	}

	public void setPublicId(String publicId) {
		this.publicId = publicId;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
