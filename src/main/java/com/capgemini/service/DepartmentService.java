package com.capgemini.service;

import java.util.List;

import com.capgemini.types.DepartmentTO;
import com.capgemini.types.EmployeeTO;

public interface DepartmentService {
	/**
	 * This is the method which add department to collection.
	 * 
	 * @param Department
	 *            Transfer Object.
	 * 
	 */
	DepartmentTO add(DepartmentTO departmentTO);

	/**
	 * This is the method which update department in collection.
	 * 
	 * @param Department
	 *            Transfer Object.
	 * 
	 */
	DepartmentTO update(DepartmentTO departmentTO);

	/**
	 * This is the method which find department in collection.
	 * 
	 * @param Long
	 *            id of a department.
	 * 
	 * @return Department Transfer Object.
	 */
	DepartmentTO findOne(Long id);

	/**
	 * This is the method which remove department by its id.
	 * 
	 * @param Long
	 *            id of a department.
	 * 
	 */
	void remove(Long id);

	/**
	 * This is the method which add employee to department.
	 * 
	 * @param Long
	 *            id of a car and Long id of department.
	 * 
	 */
	void addEmployeeToDepartment(Long idEmployee, Long idDepartment);

	/**
	 * This is the method which remove employee to department.
	 * 
	 * @param Long
	 *            id of a car and Long id of department.
	 * 
	 */
	void removeEmployeeFromDepartment(Long idEmployee, Long idDepartment);

	/**
	 * This is the method which find employees by department.
	 * 
	 * @param Long
	 *            id of a department.
	 * @return List of employees.
	 */
	List<EmployeeTO> getEmployeesFromDepartment(Long idDepartment);

	/**
	 * This is the method which find all departments.
	 * 
	 * 
	 * @return List of departments.
	 */
	List<DepartmentTO> findAll();
}
