package com.pk.springbootrestapi.common.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pk.springbootrestapi.dto.EmployeeDto;
import com.pk.springbootrestapi.entity.Employee;

@Component
public class CommonUtils {
	
	@Autowired
	private ModelMapper mapper;
	
	public EmployeeDto mapEmployeeToEmployeeDto(Employee employee) {
		return mapper.map(employee, EmployeeDto.class);
	}
	
	public Employee mapEmployeeDtoToEmployee(EmployeeDto employeeDto) {
		return mapper.map(employeeDto, Employee.class);
	}
}
