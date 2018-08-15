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
				"select car from CarEntity car where upper(car.carType) like concat(upper(:carType), '%') and "
						+ "(car.brand) like concat((:brand), '%')",
				CarEntity.class);
		query.setParameter("car_type", carType);
		query.setParameter("model", brand);
		return query.getResultList();
	}

	@Override
	public List<CarEntity> findByAttendantEmployees(EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
