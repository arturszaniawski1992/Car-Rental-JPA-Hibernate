package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.DepartmentDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.DepartmentEntity;
import com.capgemini.domain.EmployeeEntity;

@Repository
public class DepartmentDaoImpl extends AbstractDao<DepartmentEntity, Long> implements DepartmentDao {

	@Override
	public List<EmployeeEntity> findEmployesByDepartmentAndAttendantCar(DepartmentEntity department, CarEntity car) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
				"SELECT e FROM EmployeeEntity e WHERE e.departmentEntity = :department AND :car MEMBER OF e.attendCars",
				EmployeeEntity.class);
		query.setParameter("department", department);
		query.setParameter("car", car);
		return query.getResultList();
	}

	@Override
	public List<EmployeeEntity> findEmployeesByDepartmentEntityId(Long id) {
		TypedQuery<EmployeeEntity> query = entityManager
				.createQuery("SELECT em FROM EmployeeEntity em WHERE em.departmentEntity.id=:id", EmployeeEntity.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
