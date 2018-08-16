package com.capgemini.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.CarEntity.CarEntityBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarDaoTest {

	@Autowired
	private CarDao carRepository;

	@Test
	public void shouldFindCarByTypeAndBrand() {
		// given

		CarEntity car1 = new CarEntityBuilder().withBrand("Mercedes").withModel("w200").withType("kombi").build();

		// when
		List<CarEntity> cars = carRepository.findByCarTypeAndBrand("kombi", "Mercedes");
		cars.add(car1);
		// when
		assertNotNull(cars);
		assertEquals(cars.get(0).getBrand(), car1.getBrand());
		assertEquals(cars.get(0).getType(), car1.getType());
	}
	


	
	
}
