package com.capgemini.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.types.CarTO;
import com.capgemini.types.CarTO.CarTOBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CarServiceTest {

	@Autowired
	private CarService carService;

	@Autowired
	private EmployeeService employeeService;

	@Before
	public void setUp() {
		carService.deleteAll();
	}

	@Test
	public void shouldFindCarById() {
		// given
		CarTO car = new CarTOBuilder().withBrand("Audi").withType("sedan").withModel("A4").withPower(200)
				.withEngineCapacity(1.8).withColor("Black").withYear(2015).withMilleage(15000).build();
		CarTO savedCar = carService.saveCar(car);

		// when
		CarTO selectedCar = carService.findCarById(savedCar.getId());

		// then
		assertThat(savedCar.getBrand()).isEqualTo(selectedCar.getBrand());
		assertThat(savedCar.getId()).isEqualTo(selectedCar.getId());
	}

	@Test
	public void shouldDeleteAllCarsFromRepository() {
		// given
		String brand = "Audi";
		String type = "sedan";
		CarTO car = new CarTOBuilder().withBrand(brand).withType(type).withModel("A4").withPower(200)
				.withEngineCapacity(1.8).withMilleage(15000).withColor("Black").withYear(2015).build();
		CarTO car2 = new CarTOBuilder().withBrand(brand).withType(type).withModel("A4").withPower(200)
				.withEngineCapacity(1.8).withMilleage(5000).withColor("Black").withYear(2015).build();

		carService.saveCar(car);
		carService.saveCar(car2);

		// when
		carService.deleteAll();
		List<CarTO> cars = carService.findAll();

		// then
		assertThat(cars).isEmpty();
	}

	@Test
	public void shouldAddCarAndReturnAddedCar() {
		// given
		CarTO carTO = new CarTOBuilder().withBrand("Audi").withModel("A4").withColor("black").withType("sedan").build();
		int sizeBeforeAdding = carService.findAll().size();
		// when
		CarTO addedCar = carService.add(carTO);
		// then
		assertEquals("Audi", addedCar.getBrand());
		assertEquals("sedan", addedCar.getType());
		assertEquals(null, addedCar.getContracts());
		assertEquals(sizeBeforeAdding + 1, carService.findAll().size());
	}

	@Test
	public void shouldFindAllCars() {
		// given
		CarTO car = new CarTOBuilder().withBrand("Audi").withType("sedan").withModel("A4").withPower(200)
				.withEngineCapacity(1.8).withColor("Black").withYear(2015).withMilleage(15000).build();
		List<CarTO> cars = new ArrayList<>();
		cars.add(car);
		carService.saveCar(car);

		// when
		int size = carService.findAll().size();
		// then
		assertEquals(1, size);
	}

}