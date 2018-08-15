package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.CarEntity;

public interface CarService {
	
	CarEntity add(CarEntity carEntity);

	CarEntity update(CarEntity carEntity);

	CarEntity findOne(Long id);

	List<CarEntity> findAll();

	void addAttendantToCar(Long idCar, Long idAttendant);

	void removeCarById(Long id);

	List<CarEntity> getCarsByCarTypeAndBrand(String carType, String brand);

	List<CarEntity> getCarsByAttendantId(Long idEmployee);

	

}
