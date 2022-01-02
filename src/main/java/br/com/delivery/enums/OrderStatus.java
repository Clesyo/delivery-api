package br.com.delivery.enums;

public enum OrderStatus {

	PENDING("Pendente"), WAITING("Aguardando"), PREPARING("Preparando"), CALLED_OFF("Cancelado"), PAID_OUT("Pago");

	private String description;

	OrderStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
