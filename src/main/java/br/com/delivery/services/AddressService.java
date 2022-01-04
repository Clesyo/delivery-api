package br.com.delivery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.dtos.AddressDto;
import br.com.delivery.forms.AddressForm;
import br.com.delivery.models.repository.AddressRepository;
import br.com.delivery.validator.AddressValidator;

@Service
public class AddressService implements IAddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private AddressValidator validator;

	@Override
	public AddressDto save(AddressForm form) {
		// TODO Auto-generated method stub
		var address = form.toAddress();
		validator.validate(form, address);

		address = addressRepository.save(address);
		
		return AddressDto.convetTo(address);
	}

}
