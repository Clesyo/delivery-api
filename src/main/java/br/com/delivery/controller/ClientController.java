package br.com.delivery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.delivery.dtos.ClientDto;
import br.com.delivery.dtos.OrderDto;
import br.com.delivery.forms.ClientForm;
import br.com.delivery.interfaces.IClientService;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

	@Autowired
	private IClientService clientService;
	
	@PostMapping
	@ResponseStatus(code = CREATED)
	public ClientDto save(@RequestBody @Valid ClientForm form) {
		return clientService.save(form);
	}

	@GetMapping("/order/{id}")
	@ResponseStatus(OK)
	public OrderDto findOrderClient(@PathVariable Long id, @RequestHeader String token) {
		return clientService.findOrder(id, token);
	}

}
