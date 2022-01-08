package br.com.delivery.interfaces;

import br.com.delivery.dtos.OrderDto;
import br.com.delivery.enums.OrderStatus;
import br.com.delivery.forms.OrderForm;

public interface IOrderService {

	OrderDto save(OrderForm form);
	OrderDto changeStatusOrder(Long id, OrderStatus status);
	
}
