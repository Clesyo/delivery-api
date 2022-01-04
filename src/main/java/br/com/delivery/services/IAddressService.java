package br.com.delivery.services;

import br.com.delivery.dtos.AddressDto;
import br.com.delivery.forms.AddressForm;

public interface IAddressService {

	AddressDto save(AddressForm form);
}
