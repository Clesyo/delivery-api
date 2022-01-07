package br.com.delivery.dtos;

import br.com.delivery.models.OrderItem;

public class OrderItemDto {

	private String product;
	private Integer amount;

	public OrderItemDto(OrderItem item) {

		this.product = item.getProduct().getName();
		this.amount = item.getAmount();
	}
	
	public static OrderItemDto convert(OrderItem item) {
		return new OrderItemDto(item);
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
