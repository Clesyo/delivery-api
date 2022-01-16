package br.com.delivery.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.delivery.enums.OrderStatus;
import br.com.delivery.enums.OrderType;
import br.com.delivery.enums.PaymentMethod;
import br.com.delivery.exception.InvalidException;
import br.com.delivery.forms.PaymentForm;
import br.com.delivery.models.Order;
import br.com.delivery.models.Payment;

@Service
public class PaymentValidator {

	private BigDecimal troco = BigDecimal.ZERO;

	private BigDecimal total = BigDecimal.ZERO;

	public void validate(PaymentForm form, Payment payment, Order order) {
		var totalOrder = order.getTotal();

		if (order.getStatus().equals(OrderStatus.PAID_OUT)) {
			throw new InvalidException("Pedido já foi pago.");
		}

		if (order.getType().equals(OrderType.HOME)) {

			if (form.getPaymento().equals(PaymentMethod.DINHEIRO.name())
					&& !order.getStatus().equals(OrderStatus.PENDING_PAY)) {
				throw new InvalidException("Pedido não pode ser pago.");
			}
		}

		if (order.getType().equals(OrderType.DELIVERY)) {

			if (form.getPaymento().equals(PaymentMethod.DINHEIRO.name())
					&& !order.getStatus().equals(OrderStatus.IN_TRANSIT)) {

				throw new InvalidException("Pedido não pode ser pago.");
			}

			if (!order.getStatus().equals(OrderStatus.PENDING)) {
				throw new InvalidException("Pedido não pode ser pago.");
			}
		}

		if (form.getPaymento().equals(PaymentMethod.DINHEIRO.name())) {

			if (form.getDiscount().intValue() > 0) {

				total = totalOrder.subtract(form.getDiscount());
				troco = form.getPaid().subtract(total);
			}else {
				
				troco = form.getPaid().subtract(totalOrder);
			}

		}
		if (form.getPaid().doubleValue() < totalOrder.doubleValue()) {
			throw new InvalidException("Valor pago é inferior ao total do pedido.");
		}
		total = totalOrder;
		payment.setTroco(troco);
		payment.setTotal(total);
		payment.setOrder(order);
		
		troco = BigDecimal.ZERO;
		total = BigDecimal.ZERO;
	}
}
