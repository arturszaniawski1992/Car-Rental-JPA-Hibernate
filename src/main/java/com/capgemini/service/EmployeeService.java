package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;

public interface EmployeeService {

	EmployeeEntity getEmployee(Long id);

	List<EmployeeEntity> findAll();

	EmployeeEntity add(EmployeeEntity employeeEntity);
}
