package br.com.delivery.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.dtos.OrderDto;
import br.com.delivery.enums.OrderStatus;
import br.com.delivery.forms.OrderForm;
import br.com.delivery.interfaces.IOrderService;
import br.com.delivery.models.Order;
import br.com.delivery.models.OrderItem;
import br.com.delivery.models.repository.OrderRepository;
import br.com.delivery.validator.OrderValidator;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderValidator orderValidator;

	@Autowired
	private OrderRepository orderRepository;

	private Double total = 0.00;

	@Override
	public OrderDto save(OrderForm form) {
		// TODO Auto-generated method stub
		var order = form.toOrder();
		orderValidator.validate(form, order);
		order.setItems(buildListItem(form, order));
		order.setTotal(new BigDecimal(total));
		order.setStatus(OrderStatus.CREATED);
		order = orderRepository.save(order);
		return OrderDto.convert(order);
	}

	private List<OrderItem> buildListItem(OrderForm form, Order order) {
		return form.getItems().stream().map(itemForm -> {
			var item = itemForm.toOrderItem();
			orderValidator.validateProduct(itemForm, item, order);
			var price = item.getProduct().getPrice().doubleValue();
			total += (price * itemForm.getAmount());
			return item;
		}).toList();
	}

}
