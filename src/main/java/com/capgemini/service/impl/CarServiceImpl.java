package com.capgemini.service.impl;

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
	public CarServiceImpl(CarDao carRepository, EmployeeDao employeeRepository) {
		super();
		this.carRepository = carRepository;
		this.employeeRepository = employeeRepository;
	}

	@Override
	@Transactional(readOnly = false)
	public CarTO add(CarTO carTO) {
		CarEntity cars = carRepository.save(CarMapper.toCarEntity(carTO));
		return CarMapper.toCarTO(cars);
	}

	@Override
	@Transactional(readOnly = false)
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
	@Transactional(readOnly = false)
	public void addAttendantToCar(Long idCar, Long idAttendant) {
		CarEntity car = carRepository.findOne(idCar);
		List<EmployeeEntity> employees = car.getAttendantEmployees();
		employees.add(employeeRepository.findOne(idAttendant));
		car.setAttendantEmployees(employees);
		carRepository.save(car);

	}

	@Override
	@Transactional(readOnly = false)
	public void removeCarById(Long id) {
		CarEntity car = carRepository.findOne(id);
		car.getAttendantEmployees().stream().forEach(em -> {
			List<CarEntity> list = em.getAttendCars();
			list.remove(car);
			em.setAttendCars(list);
		});
		carRepository.delete(id);

	}

	@Override
	public List<CarTO> getCarsByCarTypeAndBrand(String carType, String brand) {
		List<CarEntity> cars = carRepository.findByCarTypeAndBrand(carType, brand);
		return CarMapper.map2TOs(cars);

	}

	@Override
	public List<CarTO> getCarsByAttendantId(Long idEmployee) {
		List<CarEntity> cars = carRepository.findByAttendantEmployees(idEmployee);
		return CarMapper.map2TOs(cars);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteAll() {
		carRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = false)
	public CarTO saveCar(CarTO carTO) {
		CarEntity carEntity = carRepository.save(CarMapper.toCarEntity(carTO));
		return CarMapper.toCarTO(carEntity);
	}
}
