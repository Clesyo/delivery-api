package br.com.delivery.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.dtos.PaymentDto;
import br.com.delivery.enums.OrderStatus;
import br.com.delivery.forms.PaymentForm;
import br.com.delivery.interfaces.IOrderService;
import br.com.delivery.interfaces.IPaymentService;
import br.com.delivery.repository.OrderRepository;
import br.com.delivery.repository.PaymentRepository;
import br.com.delivery.validator.PaymentValidator;

@Service
public class PaymentService implements IPaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private PaymentValidator paymentValidator;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public PaymentDto save(PaymentForm form) {

		var order = orderRepository.findById(form.getOrderId())
				.orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado para os dados informados."));
		var payment = form.toPayment();
		paymentValidator.validate(form, payment, order);

		orderService.changeStatusOrder(order.getId(), OrderStatus.PAID_OUT);
		payment = paymentRepository.save(payment);
		return PaymentDto.convert(payment);
	}

}
