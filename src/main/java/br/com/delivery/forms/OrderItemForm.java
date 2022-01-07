package br.com.delivery.forms;

import br.com.delivery.models.OrderItem;

public class OrderItemForm {

	private Long orderId;
	
	private Long productId;
	
	private Integer amount;
	
	public OrderItem toOrderItem() {
		var item = new OrderItem();
		
		item.setAmount(amount);
		return item;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}
