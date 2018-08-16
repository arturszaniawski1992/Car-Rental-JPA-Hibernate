package com.capgemini.service;

import java.util.List;

import com.capgemini.types.DepartmentTO;
import com.capgemini.types.EmployeeTO;

public interface DepartmentService {

	DepartmentTO add(DepartmentTO departmentTO);

	DepartmentTO update(DepartmentTO departmentTO);

	DepartmentTO findOne(Long id);

	void remove(Long id);

	void addEmployeeToDepartment(Long idEmployee, Long idDepartment);

	void removeEmployeeFromDepartment(Long idEmployee, Long idDepartment);

	List<EmployeeTO> getEmployeesFromDepartment(Long idDepartment);

	List<DepartmentTO> findAll();
}
