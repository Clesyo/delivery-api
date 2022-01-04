package br.com.delivery.validator;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.forms.AddressForm;
import br.com.delivery.models.Address;
import br.com.delivery.models.repository.CityRepository;
import br.com.delivery.models.repository.ClientRepository;

@Service
public class AddressValidator {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ClientRepository clientRepository;

	public void validate(AddressForm form, Address address) {
		var city = cityRepository.findByIbgeCode(form.getIbgeCode())
				.orElseThrow(() -> new EntityNotFoundException("Cidade não encontada para os dados informados."));
		var client = clientRepository.findById(form.getClientId())
				.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado para ID informado."));

		address.setCity(city);
		address.setState(city.getState());
		address.setClient(client);
	}
}
