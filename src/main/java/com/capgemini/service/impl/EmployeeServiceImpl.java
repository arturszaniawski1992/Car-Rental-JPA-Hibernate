package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.service.EmployeeService;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeDao employeeDao;

	@Autowired

	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

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
