package br.com.delivery.dtos;

import br.com.delivery.models.User;

public class UserDto {

	private String name;
	private String email;
	private RoleDto role;

	public UserDto(User user) {
		super();
		this.name = user.getName();
		this.email = user.getEmail();
		this.role = RoleDto.convert(user.getRole());
	}

	public static UserDto convert(User user) {
		// TODO Auto-generated method stub
		return null;
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

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

}
