package com.capgemini.service;

import java.util.List;

import com.capgemini.types.CarTO;

public interface CarService {

	CarTO add(CarTO carTO);

	CarTO update(CarTO carTO);

	CarTO findCarById(Long id);

	List<CarTO> findAll();

	void addAttendantToCar(Long idCar, Long idAttendant);

	void removeCarById(Long id);

	List<CarTO> getCarsByCarTypeAndBrand(String carType, String brand);

	List<CarTO> getCarsByAttendantId(Long idEmployee);

	void deleteAll();

	CarTO saveCar(CarTO carTO);

}
