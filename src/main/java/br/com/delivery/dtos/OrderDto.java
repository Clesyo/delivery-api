package br.com.delivery.dtos;

import java.math.BigDecimal;
import java.util.List;

import br.com.delivery.models.Order;

public class OrderDto {

	private Long id;
	private String status;
	private BigDecimal total;
	private String client;
	private List<OrderItemDto> items;

	public OrderDto(Order order) {
		this.id = order.getId();
		this.status = order.getStatus().getDescription();
		this.total = order.getTotal();
		this.client = order.getClient().getName();
		this.items = order.getItems().stream().map(OrderItemDto::convert).toList();
	}

	public static OrderDto convert(Order order) {
		// TODO Auto-generated method stub
		return new OrderDto(order);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public List<OrderItemDto> getItems() {
		return items;
	}

	public void setItems(List<OrderItemDto> items) {
		this.items = items;
	}
}
