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

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeDao employeeRepository;

	@Autowired

	public EmployeeServiceImpl(EmployeeDao employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeTO getEmployeeById(Long id) {
		return EmployeeMapper.toEmployeeTO(employeeRepository.findOne(id));
	}

	@Override
	public List<EmployeeTO> findAll() {
		List<EmployeeEntity> allEmployees = employeeRepository.findAll();
		return EmployeeMapper.map2TOs(allEmployees);
	}


	@Override
	@Transactional(readOnly = false)
	public EmployeeTO saveEmployee(EmployeeTO employeeTO) {
		EmployeeEntity employeeEntity = employeeRepository.save(EmployeeMapper.toEmployeeEntity(employeeTO));
		return EmployeeMapper.toEmployeeTO(employeeEntity);
	}

}
