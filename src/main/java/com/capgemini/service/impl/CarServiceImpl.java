package com.capgemini.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.capgemini.domain.CarEntity;
import com.capgemini.service.CarService;


@Service
@Transactional
public class CarServiceImpl implements CarService {

	@Override
	public CarEntity add(CarEntity carEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarEntity update(CarEntity carEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarEntity findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAttendantToCar(Long idCar, Long idAttendant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCarById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CarEntity> getCarsByCarTypeAndBrand(String carType, String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarEntity> getCarsByAttendantId(Long idEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
