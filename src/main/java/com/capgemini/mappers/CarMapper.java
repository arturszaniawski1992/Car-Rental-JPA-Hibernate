package com.capgemini.mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.CarEntity.CarEntityBuilder;
import com.capgemini.types.CarTO;
import com.capgemini.types.CarTO.CarTOBuilder;

public class CarMapper {

	public static CarTO toCarTO(CarEntity carEntity) {
		if (carEntity == null)
			return null;

		return new CarTOBuilder().withId(carEntity.getId()).withBrand(carEntity.getBrand())
				.withModel(carEntity.getModel()).withPower(carEntity.getPower()).withMilleage(carEntity.getMilleage())
				.withEngineCapacity(carEntity.getEngineCapacity()).withYear(carEntity.getYear())
				.withColor(carEntity.getColor()).withType(carEntity.getType()).build();

	}

	public static CarEntity toCarEntity(CarTO carTO) {
		if (carTO == null)
			return null;

		return new CarEntityBuilder().withId(carTO.getId()).withBrand(carTO.getBrand()).withModel(carTO.getModel())
				.withPower(carTO.getPower()).withMilleage(carTO.getMilleage())
				.withEngineCapacity(carTO.getEngineCapacity()).withYear(carTO.getYear()).withColor(carTO.getColor())
				.withType(carTO.getType()).build();

	}

	public static List<CarTO> map2TOs(List<CarEntity> carEntities) {
		return carEntities.stream().map(CarMapper::toCarTO).collect(Collectors.toList());
	}

	public static List<CarEntity> map2Entities(Set<CarTO> carTOs) {
		return carTOs.stream().map(CarMapper::toCarEntity).collect(Collectors.toList());
	}

}