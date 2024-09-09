package com.pk.springbootrestapi.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmployeeDto {
	private long empId;
	@NotBlank(message = "First Name Should Not be Empty")
	private String firstName;
	@NotBlank(message = "LastName Should not be Empty")
	private String lastName;
	@Email(message = "pls Give Vaild Email")
	@NotBlank(message ="Email Should Not be Empty")
	private String emailId;
}
