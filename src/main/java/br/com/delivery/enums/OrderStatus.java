package br.com.delivery.enums;

public enum OrderStatus {

	CREATED("CRIADO"), PENDING("PENDENTE"), WAITING("AGUARDANDO"), PREPARING("PREPARANDO"), CALLED_OFF("CANCELADO"), PAID_OUT("PAGO");

	private String description;

	OrderStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
