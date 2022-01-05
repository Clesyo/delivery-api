package br.com.delivery.interfaces;

import br.com.delivery.dtos.ProductDto;
import br.com.delivery.forms.ProductForm;

public interface IProductService {

	ProductDto save(ProductForm form);
}
