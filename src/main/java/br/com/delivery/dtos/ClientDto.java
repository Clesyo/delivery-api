package br.com.delivery.dtos;

import java.util.List;

import br.com.delivery.models.Client;

public class ClientDto {
	private String publicId;
	private String name;
	private String email;
	private String cpf;
	private String phone;
	private List<AddressDto> addresses;

	public ClientDto(Client client) {
		this.publicId = client.getPublicId();
		this.name = client.getName();
		this.email = client.getEmail();
		this.cpf = client.getCpf();
		this.phone = client.getPhone();
		this.addresses = client.getAddresses().stream().map(AddressDto::convetTo).toList();
	}

	public static ClientDto convert(Client client) {
		return new ClientDto(client);
	}

	public String getPublicId() {
		return publicId;
	}

	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<AddressDto> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressDto> addresses) {
		this.addresses = addresses;
	}

}
