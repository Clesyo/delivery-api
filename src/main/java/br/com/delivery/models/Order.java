package br.com.delivery.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import br.com.delivery.enums.OrderStatus;

@Entity
public class Order extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@Column(columnDefinition = "default 0.00")
	private BigDecimal total;
	
	@Column(columnDefinition = "default 0.00")
	private BigDecimal troco;
	
	@Column(columnDefinition = "default 0.00")
	private BigDecimal discount;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> items;

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
}
