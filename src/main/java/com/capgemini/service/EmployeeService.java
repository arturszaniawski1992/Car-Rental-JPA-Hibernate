package com.capgemini.service;

import java.util.List;

import com.capgemini.types.EmployeeTO;

public interface EmployeeService {

	EmployeeTO getEmployeeById(Long id);

	List<EmployeeTO> findAll();

	EmployeeTO saveEmployee(EmployeeTO employeeTO);

}
