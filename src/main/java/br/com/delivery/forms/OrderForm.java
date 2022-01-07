package br.com.delivery.forms;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import br.com.delivery.models.Order;

public class OrderForm {

	private Long clientId;
	
	private BigDecimal total;

	private List<OrderItemForm> items;

	public Order toOrder(Order... orders) {
		var order = new Order();
		var list = Arrays.asList(orders);
		if (!list.isEmpty())
			order = list.get(0);
		return order;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<OrderItemForm> getItems() {
		return items;
	}

	public void setItems(List<OrderItemForm> items) {
		this.items = items;
	}

}
