package com.capgemini.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.types.CarTO;
import com.capgemini.types.CarTO.CarTOBuilder;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.EmployeeTO.EmployeeTOBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql")
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
		CarTO car = new CarTOBuilder().withBrand("Audi").withModel("A4").withColor("black").withType("sedan").build();
		int sizeBeforeAdding = carService.findAll().size();
		// when
		CarTO addedCar = carService.saveCar(car);
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

	@Test
	public void testShouldFindCarByTypeAndMark() {
		// given
		String brand = "Opel";
		String type = "sedan";

		CarTO car1 = new CarTOBuilder().withBrand("Opel").withModel("Astra").withType("sedan").withColor("black")
				.build();
		CarTO car2 = new CarTOBuilder().withBrand("Opel").withModel("Vectra").withType("sedan").withColor("red")
				.build();
		List<CarTO> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		carService.saveCar(car1);
		carService.saveCar(car2);

		// when
		List<CarTO> foundCars = carService.getCarsByCarTypeAndBrand(type, brand);

		// then
		assertNotNull(foundCars);
		assertEquals(0, foundCars.size());

	}

	@Test
	public void shouldAddAttendantToCarAndCarToAttendant() {
		// given
		CarTO car = new CarTOBuilder().withBrand("Audi").withType("sedan").withModel("A4").withPower(200)
				.withEngineCapacity(1.8).withColor("Black").withYear(2015).build();
		CarTO savedCar = carService.saveCar(car);

		EmployeeTO emp1 = new EmployeeTOBuilder().withFirstName("Artur").withLastName("Szaniawski").withSalary(15000)
				.build();

		EmployeeTO savedEmployee = employeeService.saveEmployee(emp1);

		// when
		carService.addAttendantToCar(savedCar.getId(), savedEmployee.getId());
		List<CarTO> workers = carService.getCarsByAttendantId(savedEmployee.getId());

		// then
		assertThat(workers.size()).isEqualTo(1);
		assertThat(employeeService.getEmployeeById(savedEmployee.getId()).getAttendCars().get(0))
				.isEqualTo(savedCar.getId());
	}

	@Test
	public void shouldUpdateVersionAfterUpdate() {
		// given
		CarTO car1 = new CarTOBuilder().withBrand("Opel").withModel("Astra").withType("sedan").withColor("black")
				.build();

		// when
		CarTO addedCar = carService.saveCar(car1);
		addedCar.setColor("pink");
		addedCar.setModel("Vectra");
		CarTO updatedCar = carService.update(addedCar);
		// then
		assertEquals("Opel", addedCar.getBrand());
		assertEquals("sedan", addedCar.getType());
		assertEquals("Vectra", updatedCar.getModel());
	}

	@Test
	public void shouldDeleteCarById() {
		// given

		String type = "sedan";
		String brand = "Opel";

		CarTO car1 = new CarTOBuilder().withId(1L).withBrand("Opel").withModel("Astra").withType("sedan")
				.withColor("black").build();
		CarTO car2 = new CarTOBuilder().withId(2L).withBrand("Opel").withModel("Vectra").withType("sedan")
				.withColor("red").build();
		CarTO car3 = new CarTOBuilder().withId(3L).withBrand("Opel").withModel("Vectra").withType("sedan")
				.withColor("red").build();
		carService.saveCar(car1);
		carService.saveCar(car2);
		carService.saveCar(car3);

		// when
		carService.removeCarById(car2.getId());
		List<CarTO> cars = carService.getCarsByCarTypeAndBrand(type, brand);

		// then
		assertThat(carService.findCarById(car3.getId())).isNull();
		assertThat(cars.size()).isEqualTo(2);
	}

}