package br.com.delivery.dtos;

import java.math.BigDecimal;

import br.com.delivery.models.Payment;

public class PaymentDto {

	private OrderDto order;
	
	private String payment;

	private BigDecimal troco;

	private BigDecimal discount;

	private BigDecimal paid;

	public PaymentDto(Payment payment) {
		this.order = OrderDto.convert(payment.getOrder());
		this.troco = payment.getTroco();
		this.discount = payment.getDiscount();
		this.paid = payment.getPaid();
		this.payment = payment.getPaymento().name();
	}

	public static PaymentDto convert(Payment payment) {
		// TODO Auto-generated method stub
		return new PaymentDto(payment);
	}

	public OrderDto getOrder() {
		return order;
	}

	public void setOrder(OrderDto order) {
		this.order = order;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
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

	public BigDecimal getPaid() {
		return paid;
	}

	public void setPaid(BigDecimal paid) {
		this.paid = paid;
	}

}
