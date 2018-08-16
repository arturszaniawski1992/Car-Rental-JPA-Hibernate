package com.capgemini.mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.DepartmentEntity;
import com.capgemini.domain.DepartmentEntity.DepartmentEntityBuilder;
import com.capgemini.types.CarTO;
import com.capgemini.types.DepartmentTO;
import com.capgemini.types.DepartmentTO.DepartmentTOBuilder;

public class DepartmentMapper {

	public static DepartmentTO toDepartmentTO(DepartmentEntity departmentEntity) {
		if (departmentEntity == null)
			return null;

		return new DepartmentTOBuilder().withMobile(departmentEntity.getMobile())
				.withAdressData(departmentEntity.getAdressData()).build();
	}

	public static DepartmentEntity toDepartmentEntity(DepartmentTO departmentTO) {
		if (departmentTO == null)
			return null;
		return new DepartmentEntityBuilder().withMobile(departmentTO.getMobile())
				.withAdressData(departmentTO.getAdressData()).build();

	}

	public static List<DepartmentTO> map2TOs(List<DepartmentEntity> departments) {
		return departments.stream().map(DepartmentMapper::toDepartmentTO).collect(Collectors.toList());
	}

	public static List<CarEntity> map2Entities(List<CarTO> carTOs) {
		return carTOs.stream().map(DepartmentMapper::toDepartmentEntity).collect(Collectors.toList());
	}

}
