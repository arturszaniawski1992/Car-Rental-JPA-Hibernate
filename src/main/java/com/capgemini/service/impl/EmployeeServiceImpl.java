package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.service.EmployeeService;
import com.capgemini.types.EmployeeTO;

import searchcriteria.EmployeeSearchCriteria;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeDao employeeRepository;

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeTO getEmployeeById(Long id) {
		return employeeMapper.toEmployeeTO(employeeRepository.findOne(id));
	}

	@Override
	public List<EmployeeTO> findAll() {
		List<EmployeeEntity> allEmployees = employeeRepository.findAll();
		return employeeMapper.map2TOs(allEmployees);
	}

	@Override
	@Transactional(readOnly = false)
	public EmployeeTO saveEmployee(EmployeeTO employeeTO) {
		EmployeeEntity employeeEntity = employeeRepository.save(employeeMapper.toEmployeeEntity(employeeTO));
		return employeeMapper.toEmployeeTO(employeeEntity);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteAll() {
		employeeRepository.deleteAll();
	}

	@Override
	public List<EmployeeTO> findEmployeeByCriteria(EmployeeSearchCriteria employeeSearchCriteria) {
		List<EmployeeEntity> allEmployeesByCriteria = employeeRepository.findEmployeeByCriteria(employeeSearchCriteria);
		return employeeMapper.map2TOs(allEmployeesByCriteria);
	}

}
