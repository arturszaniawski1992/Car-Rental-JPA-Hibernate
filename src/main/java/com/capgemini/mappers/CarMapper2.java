package com.capgemini.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.CarEntity.CarEntityBuilder;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.types.CarTO;
import com.capgemini.types.CarTO.CarTOBuilder;

@Component
public class CarMapper2 {

	@PersistenceContext
	EntityManager entityManager;

	public CarTO toCarTO(CarEntity carEntity) {
		if (carEntity == null)
			return null;

		return new CarTOBuilder().withId(carEntity.getId()).withBrand(carEntity.getBrand())
				.withModel(carEntity.getModel()).withPower(carEntity.getPower()).withMilleage(carEntity.getMilleage())
				.withEngineCapacity(carEntity.getEngineCapacity()).withYear(carEntity.getYear())
				.withColor(carEntity.getColor()).withType(carEntity.getType())
				.withAttendantEmployees(
						carEntity.getAttendantEmployees().stream().map(e -> e.getId()).collect(Collectors.toList()))
				.build();

	}

	public CarEntity toCarEntity(CarTO carTO) {
		if (carTO == null)
			return null;

		List<Long> attendantEmployees = carTO.getAttendantEmployees();
		List<EmployeeEntity> listOfEmployees = new ArrayList<>();
		for (Long id : attendantEmployees) {
			listOfEmployees.add(entityManager.getReference(EmployeeEntity.class, id));
		}

		return new CarEntityBuilder().withId(carTO.getId()).withBrand(carTO.getBrand()).withModel(carTO.getModel())
				.withPower(carTO.getPower()).withMilleage(carTO.getMilleage())
				.withEngineCapacity(carTO.getEngineCapacity()).withYear(carTO.getYear()).withColor(carTO.getColor())
				.withType(carTO.getType()).withAttendantEmployees(listOfEmployees).build();

	}

	public List<CarTO> map2TOs(List<CarEntity> carEntities) {
		return carEntities.stream().map(this::toCarTO).collect(Collectors.toList());
	}

	public List<CarEntity> map2Entities(Set<CarTO> carTOs) {
		return carTOs.stream().map(this::toCarEntity).collect(Collectors.toList());
	}

}
