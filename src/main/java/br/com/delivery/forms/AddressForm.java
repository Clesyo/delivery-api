package br.com.delivery.forms;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.delivery.models.Address;

public class AddressForm {

	@NotBlank(message = "CEP não pode ser vazio.")
	private String zipCode;

	@NotNull(message = "Número não poder vazio.")
	private Integer number;

	@NotBlank(message = "Logradouro não pode ser vazio.")
	private String street;

	private String complement;

	@NotBlank(message = "Bairro não pode ser vazio.")
	private String district;

	@NotNull(message = "Codigo do IBGE não pode ser vazio.")
	private Integer ibgeCode;
	
	@NotNull(message = "ID do cliente não pode ser vazio.")
	private Long clientId;

	public Address toAddress(Address... addresses) {
		var address = new Address();
		var list = Arrays.asList(addresses);

		if (!list.isEmpty())
			address = list.get(0);

		address.setZipCode(zipCode);
		address.setStreet(street);
		address.setNumber(number);
		address.setComplement(complement);
		address.setDistrict(district);
		return address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getIbgeCode() {
		return ibgeCode;
	}

	public void setIbgeCode(Integer ibgeCode) {
		this.ibgeCode = ibgeCode;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
}
