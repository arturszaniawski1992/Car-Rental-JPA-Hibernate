package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.dao.DepartmentDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.DepartmentEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.DepartmentMapper;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.service.DepartmentService;
import com.capgemini.types.DepartmentTO;
import com.capgemini.types.EmployeeTO;

public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentRepository;

	@Autowired
	private EmployeeDao employeeRepository;

	@Override
	public DepartmentTO add(DepartmentTO departmentTO) {
		DepartmentEntity departmentEntity = departmentRepository
				.save(DepartmentMapper.toDepartmentEntity(departmentTO));
		return DepartmentMapper.toDepartmentTO(departmentEntity);
	}

	@Override
	public DepartmentTO update(DepartmentTO departmentTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentTO findOne(Long id) {
		DepartmentEntity departmentEntity = departmentRepository.findOne(id);
		return DepartmentMapper.toDepartmentTO(departmentEntity);
	}

	@Override
	public void remove(Long id) {

	}

	@Override
	public void addEmployeeToDepartment(Long idEmployee, Long idDepartment) {

	}

	@Override
	public void removeEmployeeFromDepartment(Long idEmployee, Long idDepartment) {

	}

	@Override
	public List<EmployeeTO> getEmployeesFromDepartment(Long idDepartment) {
		List<EmployeeEntity> employees = employeeRepository.findAll();
		return EmployeeMapper.map2TOs(employees);
	}

	@Override
	public List<DepartmentTO> findAll() {
		List<DepartmentEntity> departments = departmentRepository.findAll();
		return DepartmentMapper.map2TOs(departments);
	}

}
