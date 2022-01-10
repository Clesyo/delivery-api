package br.com.delivery.interfaces;

import br.com.delivery.dtos.ClientDto;
import br.com.delivery.dtos.OrderDto;
import br.com.delivery.forms.ClientForm;

public interface IClientService {

	ClientDto save(ClientForm form);
	
	OrderDto findOrder(Long id, String token);
}
