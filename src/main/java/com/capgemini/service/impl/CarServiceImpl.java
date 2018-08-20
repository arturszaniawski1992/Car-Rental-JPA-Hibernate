package com.capgemini.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.CarDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.service.CarService;
import com.capgemini.types.CarTO;

@Service
@Transactional(readOnly = true)

public class CarServiceImpl implements CarService {

	private final CarDao carRepository;
	private final EmployeeDao employeeRepository;

	@Autowired
	CarMapper carMapper;

	@Autowired
	public CarServiceImpl(CarDao carRepository, EmployeeDao employeeRepository) {
		this.carRepository = carRepository;
		this.employeeRepository = employeeRepository;
	}

	@Override
	@Transactional(readOnly = false)
	public CarTO update(CarTO carTO) {
		CarEntity carEntity = carRepository.update(carMapper.toCarEntity(carTO));
		return carMapper.toCarTO(carEntity);
	}

	@Override
	public CarTO findCarById(Long id) {
		return carMapper.toCarTO(carRepository.findOne(id));
	}

	@Override
	public List<CarTO> findAll() {
		List<CarEntity> allCars = carRepository.findAll();
		return carMapper.map2TOs(allCars);
	}

	@Override
	@Transactional(readOnly = false)
	public void addAttendantToCar(Long idCar, Long idAttendant) {
		CarEntity car = carRepository.findOne(idCar);
		List<EmployeeEntity> employees = car.getAttendantEmployees();
		employees.add(employeeRepository.getOne(idAttendant));
		car.setAttendantEmployees(employees);
		carRepository.save(car);

	}

	@Override
	@Transactional(readOnly = false)
	public void removeCarById(Long id) {
		carRepository.delete(id);

	}

	@Override
	public List<CarTO> getCarsByCarTypeAndBrand(String carType, String brand) {
		List<CarEntity> cars = carRepository.findByCarTypeAndBrand(carType, brand);
		return carMapper.map2TOs(cars);

	}

	@Override
	public List<CarTO> getCarsByAttendantId(Long idEmployee) {
		List<CarEntity> cars = carRepository.findByAttendantEmployees(idEmployee);
		return carMapper.map2TOs(cars);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteAll() {
		carRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = false)
	public CarTO saveCar(CarTO carTO) {
		CarEntity carEntity = carRepository.save(carMapper.toCarEntity(carTO));
		return carMapper.toCarTO(carEntity);
	}

	@Override
	public List<CarTO> getCarsRentedByMoreThanTenCustomers() {
		List<CarEntity> cars = carRepository.findCarsRentedByMoreThenTenCustomers();
		return carMapper.map2TOs(cars);

	}

	@Override

	public int getCountOfCarsRentedBetwenDates(LocalDate firstDate, LocalDate secondDate) {
		return carRepository.getCountOfCarsRentedBetwenDates(firstDate, secondDate);
	}
}
