package br.com.delivery.forms;

import br.com.delivery.enums.OrderOperation;
import br.com.delivery.enums.OrderStatus;
import br.com.delivery.models.LogOrder;

public class LogOrderForm {

	private String status;

	private String operation;

	public LogOrder toLogOrder() {
		var log = new LogOrder();
		log.setStatus(OrderStatus.valueOf(status));
		log.setOperation(OrderOperation.valueOf(operation));
		return log;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
