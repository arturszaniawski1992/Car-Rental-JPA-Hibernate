package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

	@Override
	public List<CarEntity> findByCarTypeAndBrand(String carType, String brand) {
		
		TypedQuery<CarEntity> query = entityManager.createQuery(
				"select car from CarEntity car where upper(car.type) like concat(upper(:car_type), '%') and "
						+ "(car.brand) like concat(upper(:brand), '%')",
				CarEntity.class);
		query.setParameter("car_type", carType);
		query.setParameter("brand", brand);
		return query.getResultList();
	}

	@Override
	public List<CarEntity> findByAttendantEmployees(Long employeeId) {
		EmployeeEntity employee = entityManager.getReference(EmployeeEntity.class, employeeId);
		TypedQuery<CarEntity> query = entityManager.createQuery
				("select car from CarEntity car  where :id MEMBER OF car.attendantEmployees", CarEntity.class);
		query.setParameter("id", employee);
		return query.getResultList();
	}

}
