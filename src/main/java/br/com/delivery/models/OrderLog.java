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
public class OrderLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus statusOrder;
	
	@Enumerated(EnumType.STRING)
	private OrderOperation operation;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@PrePersist
	protected void prePersiste() {
		this.createAt = new Date();
	}
}
