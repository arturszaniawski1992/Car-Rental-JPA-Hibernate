package com.capgemini.service;

import java.util.List;

import com.capgemini.types.EmployeeTO;

public interface EmployeeService {
	/**
	 * This is the method getting employee by id.
	 * 
	 * @param Long
	 *            as id of an employee.
	 * 
	 * @return Employee Transfer Object.
	 */
	EmployeeTO getEmployeeById(Long id);

	/**
	 * This is the method getting all employee from collection.
	 * 
	 * @return List of all employees.
	 */
	List<EmployeeTO> findAll();

	/**
	 * This is the method save employee in collection.
	 * 
	 * @param Employee
	 *            Transfer Object as employee.
	 * 
	 * @return Employee Transfer Object.
	 */
	EmployeeTO saveEmployee(EmployeeTO employeeTO);

}
