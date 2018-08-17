package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.CarEntity;

public interface CarDao extends Dao<CarEntity, Long> {

	List<CarEntity> findByCarTypeAndBrand(String carType, String brand);

	List<CarEntity> findByAttendantEmployees(Long employeeId);
}
