package com.capgemini.dao.impl;

import java.time.LocalDate;
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
		TypedQuery<CarEntity> query = entityManager.createQuery(
				"select car from CarEntity car  where :id MEMBER OF car.attendantEmployees", CarEntity.class);
		query.setParameter("id", employee);
		return query.getResultList();
	}

	@Override
	public List<CarEntity> findCarsRentedByMoreThenTenCustomers() {
		TypedQuery<CarEntity> query = entityManager.createQuery(
				"select ce from CarEntity ce join ce.contracts c group by ce.id having count(distinct c.customerEntity.id)>=10",
				CarEntity.class);
		return query.getResultList();

	}

	@Override
	public int getCountOfCarsRentedBetwenDates(LocalDate firstDate, LocalDate secondDate) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
				"select count(c) from ContractEntity c where c.rentDate between :firstDate and :secondDate",
				CarEntity.class);
		query.setParameter("firstDate", firstDate);
		query.setParameter("secondDate", secondDate);
		return query.getMaxResults();
	}

}
