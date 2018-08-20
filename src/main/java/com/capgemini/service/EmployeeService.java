package com.capgemini.service;

import java.util.List;

import com.capgemini.types.EmployeeTO;

import searchcriteria.EmployeeSearchCriteria;

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

	/**
	 * This is the method remove all employess from repo.
	 * 
	 * @param Employee
	 *            Transfer Object as employee.
	 */
	void deleteAll();

	/**
	 * This is the method find employees by criteria.
	 * 
	 * @param List
	 *            of parameters.
	 * 
	 * @return List of employees by criteria.
	 */
	List<EmployeeTO> findEmployeeByCriteria(EmployeeSearchCriteria employeeSearchCriteria);

}
