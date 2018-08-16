package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public EmployeeEntity getEmployee(Long id) {
		return employeeDao.getOne(id);
	}

	@Override
	public List<EmployeeEntity> findAll() {
		return employeeDao.findAll();

	}

	@Override
	public EmployeeEntity add(EmployeeEntity employeeEntity) {
		return employeeDao.save(employeeEntity);
	}

}
