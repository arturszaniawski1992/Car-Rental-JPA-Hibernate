package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.EmployeeEntity.EmployeeEntityBuilder;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.EmployeeTO.EmployeeTOBuilder;

public class EmployeeMapper {

	public static EmployeeTO toEmployeeTO(EmployeeEntity employeeEntity) {
		if (employeeEntity == null)
			return null;

		return new EmployeeTOBuilder().withFirstName(employeeEntity.getFirstName())
				.withLastName(employeeEntity.getLastName()).withSalary(employeeEntity.getSalary())
				.withDateOfBirth(employeeEntity.getDateOfBirth()).withMobile(employeeEntity.getMobile()).build();

	}

	public static EmployeeEntity toEmployeeEntity(EmployeeTO employeeTO) {
		if (employeeTO == null)
			return null;

		return new EmployeeEntityBuilder().withFirstName(employeeTO.getFirstName())
				.withLastName(employeeTO.getLastName()).withSalary(employeeTO.getSalary())
				.withDateOfBirth(employeeTO.getDateOfBirth()).withMobile(employeeTO.getMobile()).build();

	}

	public static List<EmployeeTO> map2TOs(List<EmployeeEntity> employeeEntities) {
		return employeeEntities.stream().map(EmployeeMapper::toEmployeeTO).collect(Collectors.toList());
	}

	public static List<EmployeeEntity> map2Entities(List<EmployeeTO> employeeTOs) {
		return employeeTOs.stream().map(EmployeeMapper::toEmployeeEntity).collect(Collectors.toList());
	}

}