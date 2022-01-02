package br.com.delivery.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.delivery.enums.ProductType;

@Entity
public class Product extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String description;
	
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	private ProductType type;
	
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
