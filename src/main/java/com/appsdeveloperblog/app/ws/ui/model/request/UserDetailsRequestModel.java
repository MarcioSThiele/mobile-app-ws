package com.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {

	@NotNull(message = "First name cannot be null")
	@NotEmpty(message = "First name cannot be empty")
	@NotBlank(message = "First name cannot be blank")
	@Size(min = 2, max = 50, message = "First name can be equal or grater than 2 characters and less than 50 characters")
	private String firstName;

	@NotNull(message = "Last name cannot be null")
	@NotEmpty(message = "Last name cannot be empty")
	@NotBlank(message = "Last name cannot be blank")
	@Size(min = 2, max = 50, message = "Last name can be equal or grater than 2 characters and less than 50 characters")
	private String lastName;

	@NotNull(message = "Email cannot be null")
	@NotEmpty(message = "Email cannot be empty")
	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Please, put the real email exemple: joao.pereira@gmail.com")
	private String email;

	@NotNull(message = "Password cannot be null")
	@NotEmpty(message = "Password cannot be empty")
	@NotBlank(message = "Password cannot be blank")
	@Size(min = 8, max = 16, message = "Password can be equal or grater than 8 characters and less than 16 characters")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
