package br.com.delivery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.enums.OrderOperation;
import br.com.delivery.enums.OrderStatus;
import br.com.delivery.interfaces.ILogOrderService;
import br.com.delivery.models.LogOrder;
import br.com.delivery.models.Order;
import br.com.delivery.repository.LogOrderRepository;

@Service
public class LogOrderService implements ILogOrderService {

	@Autowired
	private LogOrderRepository logRepository;

	@Override
	public void create(Order order, OrderOperation operation, OrderStatus status) {
		// TODO Auto-generated method stub
		var log = new LogOrder();

		log.setOrder(order);
		log.setOperation(operation);
		log.setStatus(status);

		logRepository.save(log);
	}

}
