package br.com.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.http.HttpStatus.*;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.delivery.dtos.OrderDto;
import br.com.delivery.enums.OrderStatus;
import br.com.delivery.forms.OrderForm;
import br.com.delivery.interfaces.IOrderService;

@RestController
@RequestMapping(path = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@PostMapping
	@ResponseStatus(CREATED)
	public OrderDto save(@RequestBody @Valid OrderForm form) {
		return orderService.save(form);
	}

	@PatchMapping("alter/{id}")
	@ResponseStatus(NO_CONTENT)
	public OrderDto changeStatus(@PathVariable Long id, @RequestBody OrderStatus status) {
		return orderService.changeStatusOrder(id, status);
	}
}
