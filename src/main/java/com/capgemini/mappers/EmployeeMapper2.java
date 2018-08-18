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
public class EmployeeMapper2 {

	@PersistenceContext
	EntityManager entityManager;

	public EmployeeTO toEmployeeTO(EmployeeEntity employeeEntity) {
		if (employeeEntity == null)
			return null;

		return new EmployeeTOBuilder().withFirstName(employeeEntity.getFirstName())
				.withLastName(employeeEntity.getLastName()).withSalary(employeeEntity.getSalary())
				.withDateOfBirth(employeeEntity.getDateOfBirth()).withMobile(employeeEntity.getMobile())
				.withAttendCars(
						employeeEntity.getAttendCars().stream().map(e -> e.getId()).collect(Collectors.toList()))
				.build();

	}

	public EmployeeEntity toEmployeeEntity(EmployeeTO employeeTO) {
		if (employeeTO == null)
			return null;

		List<Long> attendCars = employeeTO.getAttendCars();
		List<CarEntity> listOfCars = new ArrayList<>();
		for (Long id : attendCars) {
			listOfCars.add(entityManager.getReference(CarEntity.class, id));
		}

		return new EmployeeEntityBuilder().withFirstName(employeeTO.getFirstName())
				.withLastName(employeeTO.getLastName()).withSalary(employeeTO.getSalary())
				.withDateOfBirth(employeeTO.getDateOfBirth()).withMobile(employeeTO.getMobile())
				.withAttendCars(listOfCars).build();

	}

	public List<EmployeeTO> map2TOs(List<EmployeeEntity> employeeEntities) {
		return employeeEntities.stream().map(this::toEmployeeTO).collect(Collectors.toList());
	}

	public List<EmployeeEntity> map2Entities(List<EmployeeTO> employeeTOs) {
		return employeeTOs.stream().map(this::toEmployeeEntity).collect(Collectors.toList());
	}

}
