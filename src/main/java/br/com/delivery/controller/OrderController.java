package br.com.delivery.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/client/{id}")
	@ResponseStatus(OK)
	public Page<OrderDto> searchAllOrderClient(@PathVariable Long id, @PageableDefault Pageable pagination) {
		return orderService.searchAllOrderClient(id, pagination);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public OrderDto findById(@PathVariable Long id) {
		return orderService.findById(id);
	}
}
