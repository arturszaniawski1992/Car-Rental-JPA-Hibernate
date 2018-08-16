package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.DepartmentEntity;
import com.capgemini.domain.EmployeeEntity;

public interface DepartmentDao extends Dao<DepartmentEntity, Long> {

	List<EmployeeEntity> findEmployesByDepartmentAndAttendantCar(DepartmentEntity department, CarEntity car);

	List<EmployeeEntity> findEmployeesByDepartmentEntityId(Long id);
}
