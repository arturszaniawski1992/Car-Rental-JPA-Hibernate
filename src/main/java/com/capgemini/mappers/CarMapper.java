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
public class CarMapper {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This is the method which map car entity to car TO.
	 * 
	 * @param CarEntity
	 *            as car.
	 * 
	 * @return CarTO.
	 */
	public CarTO toCarTO(CarEntity carEntity) {
		if (carEntity == null)
			return null;

		CarTOBuilder carTOBuilder = new CarTOBuilder().withId(carEntity.getId()).withBrand(carEntity.getBrand())
				.withModel(carEntity.getModel()).withPower(carEntity.getPower()).withMilleage(carEntity.getMilleage())
				.withEngineCapacity(carEntity.getEngineCapacity()).withYear(carEntity.getYear())
				.withColor(carEntity.getColor()).withType(carEntity.getType());

		if (carEntity.getAttendantEmployees() != null) {
			carTOBuilder.withAttendantEmployees(
					carEntity.getAttendantEmployees().stream().map(e -> e.getId()).collect(Collectors.toList()));

		}
		return carTOBuilder.build();
	}

	/**
	 * This is the method which map car TO to car entity.
	 * 
	 * @param CarTO
	 *            as car.
	 * 
	 * @return CarEntity .
	 */
	public CarEntity toCarEntity(CarTO carTO) {
		if (carTO == null)
			return null;

		List<Long> attendantEmployees = carTO.getAttendantEmployees();
		List<EmployeeEntity> listOfEmployees = new ArrayList<>();
		if (attendantEmployees != null) {
			for (Long id : attendantEmployees) {
				listOfEmployees.add(entityManager.getReference(EmployeeEntity.class, id));
			}
		}

		CarEntityBuilder carEntityBuilder = new CarEntityBuilder().withId(carTO.getId()).withBrand(carTO.getBrand())
				.withModel(carTO.getModel()).withPower(carTO.getPower()).withMilleage(carTO.getMilleage())
				.withEngineCapacity(carTO.getEngineCapacity()).withYear(carTO.getYear()).withColor(carTO.getColor())
				.withType(carTO.getType());

		return carEntityBuilder.build();

	}

	/**
	 * This is the method which map list of cars TO to cars entity.
	 * 
	 * @param List
	 *            of CarEntities as list of cars.
	 * 
	 * @return List of cars TO.
	 */
	public List<CarTO> map2TOs(List<CarEntity> carEntities) {
		return carEntities.stream().map(this::toCarTO).collect(Collectors.toList());
	}

	/**
	 * This is the method which map list of cars entities to cars TO.
	 * 
	 * @param List
	 *            of CarTOs as list of cars.
	 * 
	 * @return List of cars entities.
	 */
	public List<CarEntity> map2Entities(Set<CarTO> carTOs) {
		return carTOs.stream().map(this::toCarEntity).collect(Collectors.toList());
	}

}
