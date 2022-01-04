package br.com.delivery.forms;

import br.com.delivery.models.User;

public class UserForm {

	private String name;
	private String email;
	private String password;
	
	public User toUser(ClientForm form) {
		var user = new User();
		user.setEmail(form.getEmail());
		user.setName(form.getName());
		user.setPassword(form.getPassword());
		return user;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
