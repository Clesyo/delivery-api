package br.com.delivery.interfaces;

import br.com.delivery.dtos.OrderDto;
import br.com.delivery.forms.OrderForm;

public interface IOrderService {

	OrderDto save(OrderForm form);
}
