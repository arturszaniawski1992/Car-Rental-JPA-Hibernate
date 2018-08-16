package com.capgemini.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.types.CarTO;
import com.capgemini.types.CarTO.CarTOBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

	@Autowired
	private CarService carService;

	@Before
	public void setUp() {
		carService.deleteAll();
	}

	@Test
	public void shouldFindCarById() {
		// given
		CarTO car = new CarTOBuilder().withBrand("Audi").withType("sedan").withModel("A4").withPower(200)
				.withEngineCapacity(1.8).withColor("Black").withYear(2015).build();
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

		carService.add(car);
		carService.add(car2);

		// when
		carService.deleteAll();
		List<CarTO> cars = carService.findAll();

		// then
		assertThat(cars).isEmpty();
	}
}
