package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.domain.DepartmentEntity;
import com.capgemini.domain.DepartmentEntity.DepartmentEntityBuilder;
import com.capgemini.types.DepartmentTO;
import com.capgemini.types.DepartmentTO.DepartmentTOBuilder;
@Service
@Transactional(readOnly = true)
public class DepartmentMapper {

	/**
	 * This is the method which map department entity to department TO.
	 * 
	 * @param DepartmentEntity
	 *            as department.
	 * 
	 * @return DepartmentTO.
	 */
	public static DepartmentTO toDepartmentTO(DepartmentEntity departmentEntity) {
		if (departmentEntity == null)
			return null;

		return new DepartmentTOBuilder().withId(departmentEntity.getId()).withMobile(departmentEntity.getMobile())
				.withAdressData(AdressMapper.toAdressDataTO(departmentEntity.getAdressData())).build();
	}

	/**
	 * This is the method which map department TO to department entity.
	 * 
	 * @param DepartmentTO
	 *            as department.
	 * 
	 * @return DepartmentEntity.
	 */
	public static DepartmentEntity toDepartmentEntity(DepartmentTO departmentTO) {
		if (departmentTO == null)
			return null;
		return new DepartmentEntityBuilder().withId(departmentTO.getId()).withMobile(departmentTO.getMobile())
				.withAdressData(AdressMapper.toAdressDataEntity(departmentTO.getAdressData())).build();

	}

	/**
	 * This is the method which map department TO to department entity.
	 * 
	 * @param DepartmentEntity
	 *            as departments.
	 * 
	 * @return DepartmentEntity.
	 */
	public static List<DepartmentTO> map2TOs(List<DepartmentEntity> departments) {
		return departments.stream().map(DepartmentMapper::toDepartmentTO).collect(Collectors.toList());
	}

	/**
	 * This is the method which map car TO to car entity.
	 * 
	 * @param DepartmentTO
	 *            as departments.
	 * 
	 * @return CarEntity .
	 */
	public static List<DepartmentEntity> map2Entities(List<DepartmentTO> departmentTOs) {
		return departmentTOs.stream().map(DepartmentMapper::toDepartmentEntity).collect(Collectors.toList());
	}

}
