package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.DepartmentEntity;
import com.capgemini.domain.EmployeeEntity;

public interface DepartmentDao extends Dao<DepartmentEntity, Long> {

	/**
	 * This is the method which find employee by department and attendat car.
	 * 
	 * @param Department
	 *            as departmentEntity and car as carEntity.
	 * 
	 * @return List of employees.
	 */

	List<EmployeeEntity> findEmployesByDepartmentAndAttendantCar(DepartmentEntity department, CarEntity car);

	/**
	 * This is the method which find employee by id of department.
	 * 
	 * @param Department
	 *            id as Long.
	 * 
	 * @return List of employees.
	 */
	List<EmployeeEntity> findEmployeesByDepartmentEntityId(Long id);
}
