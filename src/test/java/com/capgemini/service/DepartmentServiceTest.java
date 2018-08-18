package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.types.AdressDataTO;
import com.capgemini.types.AdressDataTO.AdressDataTOBuilder;
import com.capgemini.types.DepartmentTO;
import com.capgemini.types.DepartmentTO.DepartmentTOBuilder;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.EmployeeTO.EmployeeTOBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void shouldAddDepartment() {
		// given
		DepartmentTO department = new DepartmentTOBuilder().withMobile("512525252")
				.withAdressData(new AdressDataTOBuilder().withCity("Poznan").withPostCode("21-400").withNumber(15)
						.withStreet("Warszawska").build())
				.build();
		DepartmentTO savedDepratment = departmentService.add(department);
		int departmentSizeBeforeAdd = departmentService.findAll().size();
		// when
		DepartmentTO addedDepartment = departmentService.add(savedDepratment);
		// then
		assertEquals("512525252", addedDepartment.getMobile());
		assertEquals(departmentSizeBeforeAdd + 1, departmentService.findAll().size());
	}

	@Test
	@Transactional
	public void testShouldReturnAdreesOfficeAfterAdd() {
		// give
		AdressDataTO adress = new AdressDataTOBuilder().withCity("Poznan").withPostCode("21-400").withNumber(15)
				.withStreet("Warszawska").build();
		String phone = "45623951";
		DepartmentTO department = new DepartmentTOBuilder().withMobile("512525252").withAdressData(adress).build();

		// when
		DepartmentTO addedDepartment = departmentService.add(department);

		// then
		assertNotNull(addedDepartment);
		assertEquals(adress, addedDepartment.getAdressData());
		assertEquals(phone, addedDepartment.getMobile());
	}

	@Test
	public void shouldFindEmployesByDepartmentAndAttendantCar() {
		// given
		List<Long> employees = new ArrayList<>();
		EmployeeTO employee1 = new EmployeeTOBuilder().withFirstName("Artur").withLastName("Szaniawski").build();
		EmployeeTO employee2 = new EmployeeTOBuilder().withFirstName("Ada").withLastName("Szaniawski").build();
		EmployeeTO employee3 = new EmployeeTOBuilder().withFirstName("Andrzej").withLastName("Szaniawski").build();
		employees.add(employee1.getId());
		employees.add(employee2.getId());
		employees.add(employee3.getId());

		AdressDataTO adress = new AdressDataTOBuilder().withCity("Poznan").withPostCode("21-400").withNumber(15)
				.withStreet("Warszawska").build();
		DepartmentTO dep1 = new DepartmentTOBuilder().withMobile("512525252").withAdressData(adress).build();
		departmentService.add(dep1);
		dep1.setEmployees(employees);
		// when
		List<EmployeeTO> employeesByDep = departmentService.getEmployeesFromDepartment(1L);

		// then
		assertNotNull(employeesByDep);
		assertFalse(employeesByDep.size() == 3);

	}

	@Test
	public void shouldGetAllActualEmployeesFromDepartmentById() {
		// given
		AdressDataTO adress = new AdressDataTOBuilder().withCity("Poznan").withPostCode("21-400").withNumber(15)
				.withStreet("Warszawska").build();
		DepartmentTO dep1 = new DepartmentTOBuilder().withMobile("512525252").withAdressData(adress).build();
		departmentService.add(dep1);
		DepartmentTO foundDep = departmentService.findOne(1L);
		int size = foundDep.getEmployees().size();
		// when
		int sizeOfEmployeeByMethod = departmentService.getEmployeesFromDepartment(1L).size();
		// then
		assertEquals(size, sizeOfEmployeeByMethod);
	}
}