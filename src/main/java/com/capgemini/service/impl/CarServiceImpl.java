package com.capgemini.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.service.CarService;
import com.capgemini.types.CarTO;
@Service
@Transactional
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao carRepository;

	@Override
	public CarTO add(CarTO carTO) {
		CarEntity cars = carRepository.save(CarMapper.toCarEntity(carTO));
		return CarMapper.toCarTO(cars);
	}

	@Override
	public CarTO update(CarTO carTO) {
		CarEntity carEntity = carRepository.update(CarMapper.toCarEntity(carTO));
		return CarMapper.toCarTO(carEntity);
	}

	@Override
	public CarTO findCarById(Long id) {
		return CarMapper.toCarTO(carRepository.findOne(id));
	}

	@Override
	public List<CarTO> findAll() {
		List<CarEntity> allCars = carRepository.findAll();
		return CarMapper.map2TOs(allCars);
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
	public List<CarTO> getCarsByCarTypeAndBrand(String carType, String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarTO> getCarsByAttendantId(Long idEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		carRepository.deleteAll();
	}

	@Override
	public CarTO saveCar(CarTO carTO) {
		CarEntity carEntity = carRepository.save(CarMapper.toCarEntity(carTO));
		return CarMapper.toCarTO(carEntity);
	}
}
