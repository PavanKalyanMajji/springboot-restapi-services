package com.pk.springbootrestapi.service;

import java.util.List;

import com.pk.springbootrestapi.dto.EmployeeDto;

public interface EmployeeService {
	
	public EmployeeDto saveEmployee(EmployeeDto employeeDto);

	public List<EmployeeDto> getAllEmployee();

	public EmployeeDto getEmployeeById(Long id);
	
	public EmployeeDto deleteEmployeeDetailsById(long id);
}
