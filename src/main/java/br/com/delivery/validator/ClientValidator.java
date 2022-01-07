package br.com.delivery.validator;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.forms.ClientForm;
import br.com.delivery.repository.ClientRepository;
import br.com.delivery.repository.UserRepository;

@Service
public class ClientValidator {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	public void validate(ClientForm form) {
		
	 userRepository.findByEmail(form.getEmail()).ifPresent(user -> {
		 throw new EntityNotFoundException("Já existe um usuário com email informado.'");
	 });
		
	 clientRepository.findByCpf(form.getCpf()).ifPresent(client -> {
		 throw new EntityNotFoundException("Já existe um cliente com CPF informado.'");
	 });
	}
}
