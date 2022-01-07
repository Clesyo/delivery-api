package br.com.delivery.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.delivery.enums.OrderOperation;
import br.com.delivery.enums.OrderStatus;

@Entity
public class LogOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@Enumerated(EnumType.STRING)
	private OrderOperation operation;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@PrePersist
	protected void prePersiste() {
		this.createAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus statusOrder) {
		this.status = statusOrder;
	}

	public OrderOperation getOperation() {
		return operation;
	}

	public void setOperation(OrderOperation operation) {
		this.operation = operation;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
}
