package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.PositionEntity;
import com.capgemini.domain.PositionEntity.PositionEntityBuilder;
import com.capgemini.types.PositionTO;
import com.capgemini.types.PositionTO.PositionTOBuilder;

public class PositionMapper {

	/**
	 * This is the method which map position entity to position TO.
	 * 
	 * @param positionEntity
	 *            as position.
	 * 
	 * @return Position TO.
	 */
	public static PositionTO toPositionTO(PositionEntity positionEnity) {
		if (positionEnity == null)
			return null;

		return new PositionTOBuilder().withId(positionEnity.getId()).withPosition(positionEnity.getPosition()).build();

	}

	/**
	 * This is the method which map position TO to position entity.
	 * 
	 * @param PositionTO
	 *            as position.
	 * 
	 * @return Position Entity.
	 */
	public static PositionEntity toPositionEntity(PositionTO positionTO) {
		if (positionTO == null)
			return null;

		return new PositionEntityBuilder().withId(positionTO.getId()).withPosition(positionTO.getPosition()).build();

	}

	/**
	 * This is the method which map list of position entity to position TO.
	 * 
	 * @param List
	 *            of PositionEntities as list of position.
	 * 
	 * @return List of positionTO.
	 */
	public static List<PositionTO> map2TOs(List<PositionEntity> positionEntities) {
		return positionEntities.stream().map(PositionMapper::toPositionTO).collect(Collectors.toList());
	}

	/**
	 * This is the method which map list of position TO to position entity.
	 * 
	 * @param List
	 *            of PositionTOs as list of position.
	 * 
	 * @return List of positionEntities.
	 */
	public static List<PositionEntity> map2Entities(List<PositionTO> positionTOs) {
		return positionTOs.stream().map(PositionMapper::toPositionEntity).collect(Collectors.toList());
	}

}
