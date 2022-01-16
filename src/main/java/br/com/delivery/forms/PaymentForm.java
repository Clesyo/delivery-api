package br.com.delivery.forms;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.delivery.enums.PaymentMethod;
import br.com.delivery.models.Payment;

public class PaymentForm {

	@NotNull(message = "Pedido não pode ser vazio.")
	private Long orderId;
	
	@NotEmpty(message = "Tipo pagamento não pode ser vazio.")
	private String paymento;
	
	private BigDecimal troco;

	private BigDecimal discount;

	private BigDecimal paid;

	public Payment toPayment() {
		var pay = new Payment();

		pay.setPaymento(PaymentMethod.valueOf(paymento));
		pay.setDiscount(discount);
		pay.setPaid(paid);
		return pay;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getPaymento() {
		return paymento;
	}

	public void setPaymento(String paymento) {
		this.paymento = paymento;
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
