package com.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	
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
}
