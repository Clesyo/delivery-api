package br.com.delivery.services;

import java.util.Arrays;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.dtos.ClientDto;
import br.com.delivery.enums.UserType;
import br.com.delivery.forms.ClientForm;
import br.com.delivery.interfaces.IClientService;
import br.com.delivery.models.Client;
import br.com.delivery.models.repository.AddressRepository;
import br.com.delivery.models.repository.CityRepository;
import br.com.delivery.models.repository.ClientRepository;
import br.com.delivery.models.repository.RoleRepository;
import br.com.delivery.models.repository.UserRepository;
import br.com.delivery.validator.ClientValidator;

@Service
public class ClientService implements IClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ClientValidator validator;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Override
	@Transactional
	public ClientDto save(@Valid ClientForm form) {
		validator.validate(form);
		var client = form.toClient();
		createUser(form, client);
		clientRepository.save(client);
		createAddress(form, client);
		return ClientDto.convert(client);
	}

	private void createAddress(ClientForm form, Client client) {
		var city = cityRepository.findByIbgeCode(form.getIbgeCode())
				.orElseThrow(() -> new EntityNotFoundException("Cidade não encontada para os dados informados."));

		var address = form.toAddress();
		address.setCity(city);
		address.setState(city.getState());
		address.setClient(client);
		addressRepository.save(address);
		client.setAddresses(Arrays.asList(address));
	}

	private void createUser(ClientForm form, Client client) {
		var role = roleRepository.findByName(UserType.CLIENT.name())
				.orElseThrow(() -> new EntityNotFoundException("Função não encontrada."));
		var user = form.toUser();
		user.setRole(role);
		userRepository.save(user);
		client.setUser(user);
	}

}
