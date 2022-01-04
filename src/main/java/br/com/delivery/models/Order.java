package br.com.delivery.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.delivery.enums.OrderStatus;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@Column(columnDefinition = "decimal(19,2) default '0.00'")
	private BigDecimal total;

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

}
