package com.capgemini.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.types.AdressDataTO;
import com.capgemini.types.AdressDataTO.AdressDataTOBuilder;
import com.capgemini.types.CarTO;
import com.capgemini.types.CarTO.CarTOBuilder;
import com.capgemini.types.DepartmentTO;
import com.capgemini.types.DepartmentTO.DepartmentTOBuilder;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.EmployeeTO.EmployeeTOBuilder;
import com.capgemini.types.PositionTO;
import com.capgemini.types.PositionTO.PositionTOBuilder;

import searchcriteria.EmployeeSearchCriteria;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql")
@Transactional
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private CarService carService;

	@Autowired
	private DepartmentService departmentService;

	@Test

	public void shouldFindWorkerById() {
		// given
		EmployeeTO employee = new EmployeeTOBuilder().withFirstName("Artur").withLastName("Szaniawski")
				.withSalary(15000).build();

		EmployeeTO savedEmployee = employeeService.saveEmployee(employee);

		// when
		EmployeeTO selectedEmployee = employeeService.getEmployeeById(savedEmployee.getId());

		// then
		assertThat(selectedEmployee.getId()).isEqualTo(savedEmployee.getId());
	}

	@Test

	public void shouldDeleteAllEmployees() {
		// given
		EmployeeTO emp1 = new EmployeeTOBuilder().withFirstName("Artur").withLastName("Szaniawski").withSalary(15000)
				.build();
		EmployeeTO emp2 = new EmployeeTOBuilder().withFirstName("Adam").withLastName("Szaniawski").withSalary(15000)
				.build();
		employeeService.saveEmployee(emp1);
		employeeService.saveEmployee(emp2);

		// when
		employeeService.deleteAll();

		// then
		assertThat(employeeService.findAll()).isEmpty();
	}

	@Test
	@Transactional
	public void shouldReturnWorkersByFindingThemByDifferentParams() {
		// given
		PositionTO manager = new PositionTOBuilder().withPosition("manager").build();
		PositionTO accountant = new PositionTOBuilder().withPosition("accountant").build();

		EmployeeTO managerEmp = new EmployeeTOBuilder().withId(1L).withFirstName("Artur").withLastName("Szaniawski")
				.withSalary(15000).withPosition(manager).build();
		EmployeeTO accountantEmp = new EmployeeTOBuilder().withId(2L).withFirstName("Jan").withLastName("Kowalski")
				.withSalary(15000).withPosition(accountant).build();

		EmployeeTO savedEmployee1 = employeeService.saveEmployee(managerEmp);
		EmployeeTO savedEmployee2 = employeeService.saveEmployee(accountantEmp);
		AdressDataTO adress = new AdressDataTOBuilder().withCity("Poznan").withPostCode("21-400").withNumber(15)
				.withStreet("Warszawska").build();
		DepartmentTO dep1 = new DepartmentTOBuilder().withId(1L).withMobile("5452123").withAdressData(adress).build();
		DepartmentTO savedDepaartment = departmentService.add(dep1);

		departmentService.addEmployeeToDepartment(savedEmployee1.getId(), dep1.getId());
		departmentService.addEmployeeToDepartment(savedEmployee2.getId(), dep1.getId());

		CarTO car1 = new CarTOBuilder().withId(1L).withBrand("Opel").withModel("Astra").withType("sedan")
				.withColor("black").build();

		CarTO savedCar = carService.saveCar(car1);
		carService.addAttendantToCar(savedCar.getId(), savedEmployee2.getId());

		// when
		EmployeeSearchCriteria employeeSearchCriteria = new EmployeeSearchCriteria();
		employeeSearchCriteria.setPositionId(manager.getId());
		employeeSearchCriteria.setDepartmentId(savedDepaartment.getId());
		employeeSearchCriteria.setAttendantId(savedCar.getId());

		List<EmployeeTO> employees = employeeService.findEmployeeByCriteria(employeeSearchCriteria);

		// then
		assertThat(employees.size()).isEqualTo(1);

	}

}
