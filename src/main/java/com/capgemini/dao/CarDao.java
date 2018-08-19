package com.capgemini.dao;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.domain.CarEntity;

public interface CarDao extends Dao<CarEntity, Long> {

	/**
	 * This is the method which find car by type and brand.
	 * 
	 * @param Type
	 *            of car as string and brand of car as string.
	 * @return List of cars.
	 */
	List<CarEntity> findByCarTypeAndBrand(String carType, String brand);

	/**
	 * This is the method which find car by id of attendat employee.
	 * 
	 * @param Id
	 *            of employee as Long.
	 * @return List of cars.
	 */

	List<CarEntity> findByAttendantEmployees(Long employeeId);

	/**
	 * This is the method find cars rented more than ten customers.
	 * 
	 * @return List of cars.
	 */

	List<CarEntity> findCarsRentedByMoreThenTenCustomers();

	/**
	 * This is the method getting count of cars, which be rented between to
	 * dates.
	 * 
	 * @param Date
	 *            for rent.
	 * 
	 * @return Amount of cars rented between the date.
	 */

	int getCountOfCarsRentedBetwenDates(LocalDate firstDate, LocalDate secondDate);

}
