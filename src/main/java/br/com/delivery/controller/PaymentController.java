package br.com.delivery.controller;

import static org.springframework.http.HttpStatus.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.delivery.dtos.PaymentDto;
import br.com.delivery.forms.PaymentForm;
import br.com.delivery.interfaces.IPaymentService;

@RestController
@RequestMapping(path = "/payment")
public class PaymentController {

	@Autowired
	private IPaymentService  paymentService;
	
	@PostMapping("/order")
	@ResponseStatus(CREATED)
	public PaymentDto save(@RequestBody @Valid PaymentForm form) {
		return paymentService.save(form);
	}
}
