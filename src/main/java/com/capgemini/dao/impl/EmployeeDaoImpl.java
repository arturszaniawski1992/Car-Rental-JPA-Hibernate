package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;

import searchcriteria.EmployeeSearchCriteria;

@Repository
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<EmployeeEntity> findEmployeeByCriteria(EmployeeSearchCriteria employeeSearchCriteria) {

		Long car = 0L;
		Long department = 0L;
		Long position = 0L;

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select employee from EmployeeEntity employee");

		if (employeeSearchCriteria.getAttendantId() != null) {
			car = employeeSearchCriteria.getAttendantId();
			stringBuilder.append(" join employee.attendCar c where c.id =:carId");
		}

		if (employeeSearchCriteria.getDepartmentId() != null) {
			department = employeeSearchCriteria.getDepartmentId();
			if (employeeSearchCriteria.getAttendantId() != null) {
				stringBuilder.append(" and");
			} else {
				stringBuilder.append(" where");
			}
			stringBuilder.append(" employee.departmentId.id=:departmentId");
		}

		if (employeeSearchCriteria.getPositionId() != null) {
			position = employeeSearchCriteria.getPositionId();
			if (employeeSearchCriteria.getAttendantId() != null || employeeSearchCriteria.getDepartmentId() != null) {
				stringBuilder.append(" and");
			} else {
				stringBuilder.append(" where");
			}

			stringBuilder.append(" employee.position=:positionId");
		}

		TypedQuery<EmployeeEntity> query = entityManager.createQuery(stringBuilder.toString(), EmployeeEntity.class);

		if (employeeSearchCriteria.getAttendantId() != null) {
			query.setParameter("carId", car);
		}
		if (employeeSearchCriteria.getPositionId() != null) {
			query.setParameter("positionId", position);
		}
		if (employeeSearchCriteria.getDepartmentId() != null) {
			query.setParameter("departmentId", department);
		}

		return query.getResultList();
	}
}
