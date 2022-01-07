package br.com.delivery.interfaces;

import br.com.delivery.enums.OrderOperation;
import br.com.delivery.enums.OrderStatus;
import br.com.delivery.models.Order;

public interface ILogOrderService {

	void create(Order order, OrderOperation operation, OrderStatus status);
}
