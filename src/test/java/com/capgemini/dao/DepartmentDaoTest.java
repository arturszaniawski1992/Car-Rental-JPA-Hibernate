package com.capgemini.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
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
import com.capgemini.domain.DepartmentEntity;
import com.capgemini.domain.DepartmentEntity.DepartmentEntityBuilder;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.EmployeeEntity.EmployeeEntityBuilder;

import embedded.AdressDataEntity.AdressDataEntityBuilder;
import exception.InvalidCreationException;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql")
@Transactional
public class DepartmentDaoTest {

	@PersistenceContext
	EntityManager entityManager;
	@Autowired
	CarDao carRepository;
	@Autowired
	private DepartmentDao departmentRepository;
	private DepartmentEntity dep1;
	private DepartmentEntity dep2;
	private DepartmentEntity dep3;

	@Autowired
	private EmployeeDao employeeRepository;
	private EmployeeEntity employee1;
	private EmployeeEntity employee2;
	private EmployeeEntity employee3;

	@Before
	public void setup() throws InvalidCreationException {

		dep1 = new DepartmentEntityBuilder()
				.withEmployees(null).withMobile("512665212").withAdressData(new AdressDataEntityBuilder()
						.withCity("Poznan").withPostCode("21-400").withNumber(15).withStreet("Warszawska").build())
				.build();

		dep2 = new DepartmentEntityBuilder()
				.withEmployees(null).withMobile("512665212").withAdressData(new AdressDataEntityBuilder()
						.withCity("Poznan").withPostCode("21-400").withNumber(15).withStreet("Warszawska").build())
				.build();
		dep3 = new DepartmentEntityBuilder()
				.withEmployees(null).withMobile("512665212").withAdressData(new AdressDataEntityBuilder()
						.withCity("Poznan").withPostCode("21-400").withNumber(15).withStreet("Warszawska").build())
				.build();

		dep1 = departmentRepository.save(dep1);
		dep2 = departmentRepository.save(dep2);
		dep3 = departmentRepository.save(dep3);

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
	public void shouldFindEmployeesByDepartmentId() {
		// given
		List<EmployeeEntity> employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);

		dep1.setEmployees(employees);
		// when
		List<EmployeeEntity> employeesByDep = departmentRepository.findEmployeesByDepartmentEntityId(dep1.getId());

		// then
		assertNotNull(employeesByDep);
		assertEquals(3, employees.size());

	}

	@Test
	public void shouldFindEmployeesByDepartmentAndAttendantCar() {
		// given
		List<EmployeeEntity> employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);

		CarEntity car1 = new CarEntityBuilder().withBrand("Audi").withModel("A4").withType("sedan")
				.withAttendantEmployees(employees).build();
		carRepository.save(car1);
		dep1.setEmployees(employees);
		// when
		List<EmployeeEntity> employeesByDepAndCar = departmentRepository.findEmployesByDepartmentAndAttendantCar(dep1,
				car1);

		// then
		assertNotNull(employeesByDepAndCar);
		assertEquals(3, employees.size());

	}

}