package br.com.delivery.interfaces;

import br.com.delivery.dtos.PaymentDto;
import br.com.delivery.forms.PaymentForm;

public interface IPaymentService {

	PaymentDto save(PaymentForm form);
}
