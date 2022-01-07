package br.com.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.*;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.delivery.dtos.OrderDto;
import br.com.delivery.forms.OrderForm;
import br.com.delivery.interfaces.IOrderService;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@PostMapping
	@ResponseStatus(CREATED)
	public OrderDto save(@RequestBody @Valid OrderForm form) {
		return orderService.save(form);
	}
}
