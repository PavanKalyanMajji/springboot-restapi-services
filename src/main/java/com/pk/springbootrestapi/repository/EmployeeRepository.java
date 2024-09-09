package com.pk.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.springbootrestapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	public Employee deleteByEmpId(long id);
	
}
