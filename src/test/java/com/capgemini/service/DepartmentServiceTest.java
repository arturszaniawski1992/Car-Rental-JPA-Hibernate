package com.capgemini.service;

import static org.assertj.core.api.Assertions.assertThat;
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
@SpringBootTest(properties = "spring.profiles.active=hsql")
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
		int departmentSizeBeforeAdd = departmentService.findAll().size();
		// when
		DepartmentTO addedDepartment = departmentService.add(department);
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
		String phone = "512525252";
		DepartmentTO department = new DepartmentTOBuilder().withMobile("512525252").withAdressData(adress).build();

		// when
		DepartmentTO addedDepartment = departmentService.add(department);

		// then
		assertNotNull(addedDepartment);
		assertEquals(adress, department.getAdressData());
		assertEquals(phone, addedDepartment.getMobile());
	}

	@Test
	public void shouldFindEmployesByDepartmentAndAttendantCar() {
		// given
		List<Long> employees = new ArrayList<>();
		EmployeeTO employee1 = new EmployeeTOBuilder().withFirstName("Artur").withLastName("asda").build();
		EmployeeTO employee2 = new EmployeeTOBuilder().withFirstName("Ada").withLastName("sad").build();
		EmployeeTO employee3 = new EmployeeTOBuilder().withFirstName("Andrzej").withLastName("Kowalski").build();
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
		EmployeeTO emp1 = new EmployeeTOBuilder().withFirstName("Artur").withLastName("Szaniawski").withSalary(15000)
				.build();
		employeeService.saveEmployee(emp1);
		List<Long> employees = new ArrayList<>();
		employees.add(emp1.getId());
		DepartmentTO foundDep = departmentService.findOne(1L);
		foundDep.setEmployees(employees);
		int size = foundDep.getEmployees().size();
		// when
		int sizeOfEmployeeByMethod = departmentService.getEmployeesFromDepartment(1L).size();
		// then
		assertNotNull(employees);
		assertEquals(size, sizeOfEmployeeByMethod);
	}

	@Test
	public void shouldFindCarById() {
		// given

		AdressDataTO adress = new AdressDataTOBuilder().withCity("Poznan").withPostCode("21-400").withNumber(15)
				.withStreet("Warszawska").build();
		DepartmentTO dep1 = new DepartmentTOBuilder().withMobile("512525252").withAdressData(adress).build();

		DepartmentTO savedDep = departmentService.add(dep1);

		// when
		DepartmentTO selectedDep = departmentService.findOne(savedDep.getId());

		// then
		assertThat(savedDep.getId()).isEqualTo(selectedDep.getId());
	}

	@Test
	public void shouldFindThreeOutpustsInRepository() {
		// given
		AdressDataTO adress = new AdressDataTOBuilder().withCity("Poznan").withPostCode("21-400").withNumber(15)
				.withStreet("Warszawska").build();
		DepartmentTO dep1 = new DepartmentTOBuilder().withMobile("512525252").withAdressData(adress).build();
		DepartmentTO dep2 = new DepartmentTOBuilder().withMobile("454521").withAdressData(adress).build();
		DepartmentTO dep3 = new DepartmentTOBuilder().withMobile("26252").withAdressData(adress).build();
		DepartmentTO dep4 = new DepartmentTOBuilder().withMobile("25").withAdressData(adress).build();

		departmentService.add(dep1);
		departmentService.add(dep2);
		departmentService.add(dep3);
		departmentService.add(dep4);

		// when
		List<DepartmentTO> departments = departmentService.findAll();

		// then
		assertThat(departments.size()).isEqualTo(4);
	}

	@Test
	public void shouldFindTwoEmployeesInDepartment() {
		AdressDataTO adress = new AdressDataTOBuilder().withCity("Poznan").withPostCode("21-400").withNumber(15)
				.withStreet("Warszawska").build();
		DepartmentTO dep1 = new DepartmentTOBuilder().withMobile("512525252").withAdressData(adress).build();

		DepartmentTO savedDepartment = departmentService.add(dep1);

		EmployeeTO emp1 = new EmployeeTOBuilder().withFirstName("Artur").withLastName("Szaniawski").withSalary(15000)
				.build();
		EmployeeTO emp2 = new EmployeeTOBuilder().withFirstName("Artur").withLastName("Szaniawski").withSalary(15000)
				.build();

		EmployeeTO savedEmployee1 = employeeService.saveEmployee(emp1);
		EmployeeTO savedEmployee2 = employeeService.saveEmployee(emp2);

		departmentService.addEmployeeToDepartment(savedEmployee1.getId(), savedDepartment.getId());
		departmentService.addEmployeeToDepartment(savedEmployee2.getId(), savedDepartment.getId());

		// when
		List<EmployeeTO> employees = departmentService.getEmployeesFromDepartment(savedDepartment.getId());

		// then
		assertThat(employees.size()).isEqualTo(2);
		assertThat(employeeService.getEmployeeById(savedEmployee1.getId()).getDepartmentTO())
				.isEqualTo(savedDepartment.getId());
	}
	
	  @Test
	    
	    public void shouldDeleteOutpustById() {
	        //given
		  AdressDataTO adress1 = new AdressDataTOBuilder().withCity("Poznan").withPostCode("21-400").withNumber(15)
					.withStreet("Warszawska").build();	      
		  AdressDataTO adress2 = new AdressDataTOBuilder().withCity("Lukow").withPostCode("21-845").withNumber(15)
					.withStreet("Warszawska").build();
		  AdressDataTO adress3 = new AdressDataTOBuilder().withCity("Lublin").withPostCode("52-255").withNumber(15)
					.withStreet("Warszawska").build();
		  DepartmentTO dep1 = new DepartmentTOBuilder().withMobile("5452123").withAdressData(adress1).build();
		  DepartmentTO dep2 = new DepartmentTOBuilder().withMobile("69595").withAdressData(adress2).build();        
		  DepartmentTO dep3 = new DepartmentTOBuilder().withMobile("854522").withAdressData(adress3).build();
	        departmentService.add(dep1);
	        departmentService.add(dep2);
	        departmentService.add(dep3);
	        //when
	        departmentService.remove(dep3.getId());
	        List<DepartmentTO> departments = departmentService.findAll();

	        //then
	        assertThat(departmentService.findOne(dep3.getId())).isNull();
	        assertThat(departments.size()).isEqualTo(2);
	    }

	    @Test
	    public void shouldUpdateOutpust() {
	        //given
	    	String mobile="54545515";
	    	AdressDataTO adress1 = new AdressDataTOBuilder().withCity("Poznan").withPostCode("21-400").withNumber(15)
					.withStreet("Warszawska").build();	 
	    	DepartmentTO dep1 = new DepartmentTOBuilder().withMobile("5452123").withAdressData(adress1).build();
	       
	        DepartmentTO savedDepartment = departmentService.add(dep1);

	        //when
	        DepartmentTO selectedOutpost = departmentService.findOne(savedDepartment.getId());
	        selectedOutpost.setMobile(mobile);
	        departmentService.update(selectedOutpost);

	        //then
	        assertThat(departmentService.findOne(selectedOutpost.getId()).getMobile() == mobile);
	    }
}