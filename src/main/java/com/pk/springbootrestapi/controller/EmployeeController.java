package com.pk.springbootrestapi.controller;

import java.util.List;
import java.util.function.LongPredicate;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pk.springbootrestapi.dto.EmployeeDto;
import com.pk.springbootrestapi.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("app/v1/employee")
@AllArgsConstructor
public class EmployeeController {
	
	private EmployeeService employeeService;

	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@PostMapping("/")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<EmployeeDto> saveEmployeeDetails(@Valid @RequestBody EmployeeDto dto) {
		return new ResponseEntity<EmployeeDto>(employeeService.saveEmployee(dto),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<EmployeeDto>> getListOfEmployees() {
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployee(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}
	
	@DeleteMapping("/deleteEmp")
	public ResponseEntity<EmployeeDto> deleteEmployeeById(@PathParam("id") String id) {
		return ResponseEntity.ok(employeeService.deleteEmployeeDetailsById(Long.parseLong(id)));
	}
}
