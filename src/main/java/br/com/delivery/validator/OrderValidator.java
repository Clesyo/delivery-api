package br.com.delivery.validator;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.delivery.forms.OrderForm;
import br.com.delivery.forms.OrderItemForm;
import br.com.delivery.models.Order;
import br.com.delivery.models.OrderItem;
import br.com.delivery.models.repository.ClientRepository;
import br.com.delivery.models.repository.ProductRepository;

@Service
public class OrderValidator {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ClientRepository clientRepository;

	public void validate(OrderForm form, Order order) {
		var client = clientRepository.findById(form.getClientId())
				.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado para os dados informados."));
		order.setClient(client);
	}

	public void validateProduct(OrderItemForm form, OrderItem item, Order order) {
		var product = productRepository.findById(form.getProductId())
				.orElseThrow(() -> new EntityNotFoundException("Produto não encontrado para os dados informados."));

		item.setProduct(product);
		item.setOrder(order);
	}
}
