package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.ContractEntity;
import com.capgemini.domain.ContractEntity.ContractEntityBuilder;
import com.capgemini.domain.CustomerEntity;
import com.capgemini.domain.DepartmentEntity;
import com.capgemini.types.ContractTO;
import com.capgemini.types.ContractTO.ContractTOBuilder;

public class ContractMapper {

	@PersistenceContext
	static EntityManager entityManager;

	public static ContractTO toContractTO(ContractEntity contractEntity) {
		if (contractEntity == null)
			return null;
		return new ContractTOBuilder().withId(contractEntity.getId()).withRentDate(contractEntity.getRentDate())
				.withReturnDate(contractEntity.getReturnDate()).withCost(contractEntity.getCost())
				.withDepartmentFromId(contractEntity.getDepartmentFrom().getId())
				.withDepartmentToId(contractEntity.getDepartmentTo().getId())
				.withCarId(contractEntity.getCarEntity().getId())
				.withCustomerId(contractEntity.getCustomerEntity().getId()).build();
	}

	public static ContractEntity toContractEntity(ContractTO contractTO) {
		if (contractTO == null)
			return null;
		DepartmentEntity departmentEntity = new DepartmentEntity();
		DepartmentEntity department = entityManager.getReference(DepartmentEntity.class, departmentEntity);

		CarEntity carEntity = new CarEntity();
		CarEntity car = entityManager.getReference(CarEntity.class, carEntity);

		CustomerEntity customerEntity = new CustomerEntity();
		CustomerEntity customer = entityManager.getReference(CustomerEntity.class, customerEntity);

		return new ContractEntityBuilder().withId(contractTO.getId()).withRentDate(contractTO.getRentDate())
				.withReturnDate(contractTO.getReturnDate()).withCost(contractTO.getCost())
				.withDepartmentFrom(department).withDepartmentTo(department).withCar(car).withCustomer(customer)
				.build();

	}

	public static List<ContractTO> map2TOs(List<ContractEntity> contractEntities) {
		return contractEntities.stream().map(ContractMapper::toContractTO).collect(Collectors.toList());
	}

	public static List<ContractEntity> map2Entities(List<ContractTO> contractTOs) {
		return contractTOs.stream().map(ContractMapper::toContractEntity).collect(Collectors.toList());
	}

}
