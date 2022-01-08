package br.com.delivery.services;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.delivery.dtos.OrderDto;
import br.com.delivery.enums.OrderOperation;
import br.com.delivery.enums.OrderStatus;
import br.com.delivery.forms.OrderForm;
import br.com.delivery.interfaces.ILogOrderService;
import br.com.delivery.interfaces.IOrderService;
import br.com.delivery.models.Order;
import br.com.delivery.models.OrderItem;
import br.com.delivery.repository.ClientRepository;
import br.com.delivery.repository.OrderRepository;
import br.com.delivery.validator.OrderValidator;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderValidator orderValidator;

	@Autowired
	private OrderRepository orderRepository;

	private Double total = 0.00;

	@Autowired
	private ILogOrderService logService;

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public OrderDto save(OrderForm form) {
		var order = form.toOrder();
		orderValidator.validate(form, order);
		order.setItems(buildListItem(form, order));
		order.setTotal(new BigDecimal(total));
		order.setStatus(OrderStatus.CREATED);
		order = orderRepository.save(order);
		logService.create(order, OrderOperation.INSERT, OrderStatus.CREATED);
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

	@Transactional
	@Override
	public OrderDto changeStatusOrder(Long id, OrderStatus status) {
		var orderNew = orderRepository.findById(id).map(order -> {
			order.setStatus(status);
			orderRepository.save(order);
			logService.create(order, OrderOperation.UPDATE, status);
			return order;
		}).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado para ID informado."));
		return OrderDto.convert(orderNew);
	}

	@Override
	public Page<OrderDto> searchAllOrderClient(Long id, Pageable pagination) {
		var client = clientRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado para ID informado."));
		List<Order> orders = client.getOrders();
		Page<Order> page = new PageImpl<>(orders, pagination, orders.size());
		return OrderDto.convert(page);
	}

	@Override
	public OrderDto findClient(Long id) {
		// TODO Auto-generated method stub
		var client = clientRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado para ID informado."));
		orderRepository.findByClient(client);
		return null;
	}

}
