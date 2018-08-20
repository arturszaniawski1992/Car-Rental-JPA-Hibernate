package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;

import searchcriteria.EmployeeSearchCriteria;

public interface EmployeeDao extends Dao<EmployeeEntity, Long> {

	/**
	 * This is the method which find employee by search criteria.
	 * 
	 * @param List
	 *            of employee search criteria.
	 * 
	 * @return List of employees.
	 */
	List<EmployeeEntity> findEmployeeByCriteria(EmployeeSearchCriteria params);

}
