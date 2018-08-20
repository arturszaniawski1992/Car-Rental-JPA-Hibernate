package com.capgemini.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.CarEntity.CarEntityBuilder;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.EmployeeEntity.EmployeeEntityBuilder;

import exception.InvalidCreationException;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql")
@Transactional
public class CarDaoTest {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private CarDao carRepository;
	private CarEntity car1;
	private CarEntity car2;
	private CarEntity car3;

	@Autowired
	private EmployeeDao employeeRepository;
	private EmployeeEntity employee1;
	private EmployeeEntity employee2;
	private EmployeeEntity employee3;

	@Before
	public void setup() throws InvalidCreationException {
		car1 = new CarEntityBuilder().withBrand("Audi").withModel("A4").withType("kombi").withAttendantEmployees(null)
				.build();
		car2 = new CarEntityBuilder().withBrand("BMW").withModel("530").withType("kombi").withAttendantEmployees(null)
				.build();
		car3 = new CarEntityBuilder().withBrand("Mercedes").withModel("W220").withType("kombi")
				.withAttendantEmployees(null).build();
		car1 = carRepository.save(car1);
		car2 = carRepository.save(car2);
		car3 = carRepository.save(car3);

		employee1 = new EmployeeEntityBuilder().withFirstName("Artur").withLastName("Szaniawski").withAttendCars(null)
				.build();
		employee2 = new EmployeeEntityBuilder().withFirstName("Adam").withLastName("Malysz").withAttendCars(null)
				.build();
		employee3 = new EmployeeEntityBuilder().withFirstName("Jan").withLastName("Kowalski").withAttendCars(null)
				.build();
		employee1 = employeeRepository.save(employee1);
		employee2 = employeeRepository.save(employee2);
		employee3 = employeeRepository.save(employee3);

	}

	@Test
	public void shouldFindCarByTypeAndBrand() {
		// given

		CarEntity car = carRepository.findOne(1L);

		// when
		List<CarEntity> cars = carRepository.findByCarTypeAndBrand("kombi", "Audi");
		cars.add(car);
		// then
		assertNotNull(cars);
		assertEquals(cars.get(0).getBrand(), car.getBrand());
		assertEquals(cars.get(0).getType(), car.getType());
	}

	@Test
	public void shouldFindByAttendantEmployees() {
		// given
		List<EmployeeEntity> attendantEmployees = new ArrayList<>();
		attendantEmployees.add(employee1);
		attendantEmployees.add(employee2);

		List<CarEntity> attendantCars = new ArrayList<>();
		attendantCars.add(car1);

		car1.setAttendantEmployees(attendantEmployees);
		employee1.setAttendCars(attendantCars);

		// when
		List<CarEntity> carsByAttendant = carRepository.findByAttendantEmployees(employee1.getId());

		// then
		assertNotNull(carsByAttendant);
		assertTrue(carsByAttendant.size() == 1);
		assertEquals(carsByAttendant.get(0).getAttendantEmployees(), car1.getAttendantEmployees());
	}

}
