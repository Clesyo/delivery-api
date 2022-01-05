package br.com.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.delivery.dtos.AddressDto;
import br.com.delivery.forms.AddressForm;
import br.com.delivery.interfaces.IAddressService;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

	@Autowired
	private IAddressService addressService;
	
	@PostMapping
	@ResponseStatus(code = CREATED)
	public AddressDto save(@RequestBody AddressForm form) {
		return addressService.save(form);
	}
}
