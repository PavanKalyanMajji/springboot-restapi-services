package com.pk.springbootrestapi.service.impl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pk.springbootrestapi.common.utils.CommonUtils;
import com.pk.springbootrestapi.dto.EmployeeDto;
import com.pk.springbootrestapi.entity.Employee;
import com.pk.springbootrestapi.exception.ResourceNotFound;
import com.pk.springbootrestapi.repository.EmployeeRepository;
import com.pk.springbootrestapi.service.EmployeeService;
import java.util.*;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private CommonUtils commonUtils;
	
	private EmployeeRepository repository;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee=commonUtils.mapEmployeeDtoToEmployee(employeeDto);
		employee=repository.save(employee);
		return commonUtils.mapEmployeeToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<EmployeeDto> listEmployeeDto = new ArrayList<>();
		repository.findAll().forEach((employee) -> {
			listEmployeeDto.add(commonUtils.mapEmployeeToEmployeeDto(employee));
		});
		return listEmployeeDto;
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		Employee employee=repository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee Details Not found By Id :"+id));
		return commonUtils.mapEmployeeToEmployeeDto(employee);
	}

	@Override
	@Transactional
	public EmployeeDto deleteEmployeeDetailsById(long id) {
		EmployeeDto dto=getEmployeeById(id);
		Employee employee =commonUtils.mapEmployeeDtoToEmployee(dto);
		repository.deleteById(employee.getEmpId());
		return commonUtils.mapEmployeeToEmployeeDto(employee);
	}
	
}
