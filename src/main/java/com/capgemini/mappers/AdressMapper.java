package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.types.AdressDataTO;
import com.capgemini.types.AdressDataTO.AdressDataTOBuilder;

import embedded.AdressDataEntity;
import embedded.AdressDataEntity.AdressDataEntityBuilder;

public class AdressMapper {

	public static AdressDataTO toAdressDataTO(AdressDataEntity adressDataEntity) {
		if (adressDataEntity == null)
			return null;

		return new AdressDataTOBuilder().withStreet(adressDataEntity.getStreet())
				.withNumber(adressDataEntity.getNumber()).withCity(adressDataEntity.getCity())
				.withPostCode(adressDataEntity.getPostCode()).build();

	}

	public static AdressDataEntity toAdressDataEntity(AdressDataTO adressDataTO) {
		if (adressDataTO == null)
			return null;

		return new AdressDataEntityBuilder().withStreet(adressDataTO.getStreet()).withNumber(adressDataTO.getNumber())
				.withCity(adressDataTO.getCity()).withPostCode(adressDataTO.getPostCode()).build();

	}

	public static List<AdressDataTO> map2TOs(List<AdressDataEntity> adressDataEntities) {
		return adressDataEntities.stream().map(AdressMapper::toAdressDataTO).collect(Collectors.toList());
	}

	public static List<AdressDataEntity> map2Entities(List<AdressDataTO> adressDataTOs) {
		return adressDataTOs.stream().map(AdressMapper::toAdressDataEntity).collect(Collectors.toList());
	}

}
