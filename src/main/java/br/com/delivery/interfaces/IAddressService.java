package br.com.delivery.interfaces;

import br.com.delivery.dtos.AddressDto;
import br.com.delivery.forms.AddressForm;

public interface IAddressService {

	AddressDto save(AddressForm form);
}
