package com.capgemini.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.EmployeeEntity.EmployeeEntityBuilder;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.EmployeeTO.EmployeeTOBuilder;

@Component
public class EmployeeMapper {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This is the method which map employee entity to employee TO.
	 * 
	 * @param EmployeeEnitity
	 *            as employee.
	 * 
	 * @return EmployeeTO .
	 */
	public EmployeeTO toEmployeeTO(EmployeeEntity employeeEntity) {
		if (employeeEntity == null)
			return null;

		EmployeeTOBuilder employeeTOBuilder = new EmployeeTOBuilder().withId(employeeEntity.getId())
				.withFirstName(employeeEntity.getFirstName()).withLastName(employeeEntity.getLastName())
				.withSalary(employeeEntity.getSalary()).withDateOfBirth(employeeEntity.getDateOfBirth())
				.withMobile(employeeEntity.getMobile());
		if (employeeEntity.getAttendCars() != null) {
			employeeTOBuilder.withAttendCars(
					employeeEntity.getAttendCars().stream().map(e -> e.getId()).collect(Collectors.toList()));

		}
		return employeeTOBuilder.build();
	}

	/**
	 * This is the method which map employee TO to employee entity.
	 * 
	 * @param EmployeeTO
	 *            as employee.
	 * 
	 * @return EmployeeEntity .
	 */
	public EmployeeEntity toEmployeeEntity(EmployeeTO employeeTO) {
		if (employeeTO == null)
			return null;

		List<Long> attendCars = employeeTO.getAttendCars();
		List<CarEntity> listOfCars = new ArrayList<>();
		if (attendCars != null) {
			for (Long id : attendCars) {
				listOfCars.add(entityManager.getReference(CarEntity.class, id));
			}
		}

		EmployeeEntityBuilder employeeEntityBuilder = new EmployeeEntityBuilder().withId(employeeTO.getId())
				.withFirstName(employeeTO.getFirstName()).withLastName(employeeTO.getLastName())
				.withSalary(employeeTO.getSalary()).withDateOfBirth(employeeTO.getDateOfBirth())
				.withMobile(employeeTO.getMobile());
		return employeeEntityBuilder.build();
	}

	/**
	 * This is the method which map list of employees TOs to employees entities.
	 * 
	 * @param List
	 *            of EmployeeEnitities as list of employees.
	 * 
	 * @return List of employees entities.
	 */
	public List<EmployeeTO> map2TOs(List<EmployeeEntity> employeeEntities) {
		return employeeEntities.stream().map(this::toEmployeeTO).collect(Collectors.toList());
	}

	/**
	 * This is the method which map list of employees entities to employees TO.
	 * 
	 * @param List
	 *            of EmployeeTOs as list of employees.
	 * 
	 * @return List of employees entities.
	 */
	public List<EmployeeEntity> map2Entities(List<EmployeeTO> employeeTOs) {
		return employeeTOs.stream().map(this::toEmployeeEntity).collect(Collectors.toList());
	}

}
