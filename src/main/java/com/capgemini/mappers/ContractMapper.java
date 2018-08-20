package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.ContractEntity;
import com.capgemini.domain.ContractEntity.ContractEntityBuilder;
import com.capgemini.domain.CustomerEntity;
import com.capgemini.domain.DepartmentEntity;
import com.capgemini.types.ContractTO;
import com.capgemini.types.ContractTO.ContractTOBuilder;

@Component
public class ContractMapper {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This is the method which map contract entity to contract TO.
	 * 
	 * @param ContractEntity
	 *            as contract.
	 * 
	 * @return ContractTO.
	 */
	public ContractTO toContractTO(ContractEntity contractEntity) {
		if (contractEntity == null)
			return null;
		return new ContractTOBuilder().withId(contractEntity.getId()).withRentDate(contractEntity.getRentDate())
				.withReturnDate(contractEntity.getReturnDate()).withCost(contractEntity.getCost())
				.withDepartmentFromId(contractEntity.getDepartmentFrom().getId())
				.withDepartmentToId(contractEntity.getDepartmentTo().getId())
				.withCarId(contractEntity.getCarEntity().getId())
				.withCustomerId(contractEntity.getCustomerEntity().getId()).build();
	}

	/**
	 * This is the method which map contract TO to contract Entity.
	 * 
	 * @param ContractTO
	 *            as contract.
	 * 
	 * @return ContractEntity.
	 */
	public ContractEntity toContractEntity(ContractTO contractTO) {
		if (contractTO == null)
			return null;
		DepartmentEntity departmentEntity = new DepartmentEntity();
		DepartmentEntity department = entityManager.getReference(DepartmentEntity.class, departmentEntity.getId());

		CarEntity carEntity = new CarEntity();
		CarEntity car = entityManager.getReference(CarEntity.class, carEntity.getId());

		CustomerEntity customerEntity = new CustomerEntity();
		CustomerEntity customer = entityManager.getReference(CustomerEntity.class, customerEntity.getId());

		return new ContractEntityBuilder().withId(contractTO.getId()).withRentDate(contractTO.getRentDate())
				.withReturnDate(contractTO.getReturnDate()).withCost(contractTO.getCost())
				.withDepartmentFrom(department).withDepartmentTo(department).withCar(car).withCustomer(customer)
				.build();

	}

	/**
	 * This is the method which map list of contracts TO to contracts entity.
	 * 
	 * @param List
	 *            of ContractEntities as list of contracts.
	 * 
	 * @return List of contracts TO.
	 */
	public List<ContractTO> map2TOs(List<ContractEntity> contractEntities) {
		return contractEntities.stream().map(this::toContractTO).collect(Collectors.toList());
	}

	/**
	 * This is the method which map list of contracts entities to contracts TO.
	 * 
	 * @param List
	 *            of ContractTOs as list of contracts.
	 * 
	 * @return List of contracts entities.
	 */
	public List<ContractEntity> map2Entities(List<ContractTO> contractTOs) {
		return contractTOs.stream().map(this::toContractEntity).collect(Collectors.toList());
	}

}
