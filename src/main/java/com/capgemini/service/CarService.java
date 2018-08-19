package com.capgemini.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.types.CarTO;

public interface CarService {

	/**
	 * This is the method which add car to collection.
	 * 
	 * @param Car
	 *            Transfer Object.
	 * 
	 */
	CarTO add(CarTO carTO);

	/**
	 * This is the method which update car in collection.
	 * 
	 * @param Car
	 *            Transfer Object.
	 * 
	 */
	CarTO update(CarTO carTO);

	/**
	 * This is the method which find car in collection.
	 * 
	 * @param Long
	 *            id of a car.
	 * 
	 * @return Car Transfer Object.
	 */
	CarTO findCarById(Long id);

	/**
	 * This is the method which find all cars.
	 * 
	 * 
	 * @return List of cars.
	 */
	List<CarTO> findAll();

	/**
	 * This is the method which add attendant to car.
	 * 
	 * @param Long
	 *            id of a car and Long id of an attendant.
	 * 
	 */
	void addAttendantToCar(Long idCar, Long idAttendant);

	/**
	 * This is the method which remove car by its id.
	 * 
	 * @param Long
	 *            id of a car.
	 * 
	 */
	void removeCarById(Long id);

	/**
	 * This is the method which find car by type and brand.
	 * 
	 * @param Type
	 *            of car as string and brand of car as string.
	 * @return List of cars.
	 */
	List<CarTO> getCarsByCarTypeAndBrand(String carType, String brand);

	/**
	 * This is the method which find car by id of attendat employee.
	 * 
	 * @param Id
	 *            of employee as Long.
	 * @return List of cars.
	 */

	List<CarTO> getCarsByAttendantId(Long idEmployee);

	/**
	 * This is the method which remove all cars from collection.
	 * 
	 */
	void deleteAll();

	/**
	 * This is the method which save car to collection.
	 * 
	 * @param Car
	 *            Transfer object as car.
	 * 
	 */
	CarTO saveCar(CarTO carTO);

	/**
	 * This is the method find cars rented more than ten customers.
	 * 
	 * @return List of cars.
	 */
	List<CarTO> getCarsRentedByMoreThenTenCustomers();

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
