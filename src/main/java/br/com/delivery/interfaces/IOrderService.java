package br.com.delivery.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.delivery.dtos.OrderDto;
import br.com.delivery.enums.OrderStatus;
import br.com.delivery.forms.OrderForm;

public interface IOrderService {

	OrderDto save(OrderForm form);

	OrderDto changeStatusOrder(Long id, OrderStatus status);
	
	Page<OrderDto> searchAllOrderClient(Long id, Pageable pagination);

}
