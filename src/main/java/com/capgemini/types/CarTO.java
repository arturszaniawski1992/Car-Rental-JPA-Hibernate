package com.capgemini.types;

import java.util.List;

import exception.InvalidCreationException;

public class CarTO {
	private Long id;
	private String brand;
	private String model;
	private Integer power;
	private Integer milleage;
	private Double engineCapacity;
	private Integer year;
	private String color;
	private String type;
	private List<Long> contracts;
	private List<Long> attendantEmployees;

	public CarTO() {
		super();
	}

	public CarTO(CarTOBuilder builder) {
		this.id = builder.id;
		this.brand = builder.brand;
		this.model = builder.model;
		this.power = builder.power;
		this.milleage = builder.milleage;
		this.engineCapacity = builder.engineCapacity;
		this.year = builder.year;
		this.color = builder.color;
		this.type = builder.type;
		this.contracts = builder.contracts;
		this.attendantEmployees = builder.attendantEmployees;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Integer getMilleage() {
		return milleage;
	}

	public void setMilleage(Integer milleage) {
		this.milleage = milleage;
	}

	public Double getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(Double engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Long> getContracts() {
		return contracts;
	}

	public void setContracts(List<Long> contracts) {
		this.contracts = contracts;
	}

	public List<Long> getAttendantEmployees() {
		return attendantEmployees;
	}

	public void setAttendantEmployees(List<Long> attendantEmployees) {
		this.attendantEmployees = attendantEmployees;
	}

	public static CarTOBuilder builder() {
		return new CarTOBuilder();
	}

	public static class CarTOBuilder {
		private Long id;
		private String brand;
		private String model;
		private Integer power;
		private Integer milleage;
		private Double engineCapacity;
		private Integer year;
		private String color;
		private String type;
		private List<Long> contracts;
		private List<Long> attendantEmployees;

		/**
		 * Default constructor for car TO builder.
		 *
		 */
		public CarTOBuilder() {
			super();

		}

		/**
		 * This is the method which add id to car.
		 * 
		 * @param Long
		 *            as id for car.
		 * @return Id of car.
		 */
		public CarTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		/**
		 * This is the method which add brand to car.
		 * 
		 * @param String
		 *            as brand for car.
		 * @return Brand of car.
		 */
		public CarTOBuilder withBrand(String brand) {
			this.brand = brand;
			return this;
		}

		/**
		 * This is the method which add model to car.
		 * 
		 * @param String
		 *            as model for car.
		 * @return model of car.
		 */
		public CarTOBuilder withModel(String model) {
			this.model = model;
			return this;
		}

		/**
		 * This is the method which add power to car.
		 * 
		 * @param Integer
		 *            as power for car.
		 * @return power of car.
		 */
		public CarTOBuilder withPower(Integer power) {
			this.power = power;
			return this;
		}

		/**
		 * This is the method which add milleage to car.
		 * 
		 * @param Integer
		 *            as brand for car.
		 * @return milleage of car.
		 */
		public CarTOBuilder withMilleage(Integer milleage) {
			this.milleage = milleage;
			return this;

		}

		/**
		 * This is the method which add engine capacity to car.
		 * 
		 * @param Double
		 *            as engine capacity for car.
		 * @return engine capacity of car.
		 */
		public CarTOBuilder withEngineCapacity(Double engineCapacity) {
			this.engineCapacity = engineCapacity;
			return this;

		}

		/**
		 * This is the method which add year to car.
		 * 
		 * @param Integer
		 *            as year for car.
		 * @return year of car.
		 */
		public CarTOBuilder withYear(Integer year) {
			this.year = year;
			return this;

		}

		/**
		 * This is the method which add brand to color.
		 * 
		 * @param String
		 *            as color for car.
		 * @return color of car.
		 */
		public CarTOBuilder withColor(String color) {
			this.color = color;
			return this;

		}

		/**
		 * This is the method which add type to car.
		 * 
		 * @param String
		 *            as type for car.
		 * @return type of car.
		 */
		public CarTOBuilder withType(String type) {
			this.type = type;
			return this;

		}

		/**
		 * This is the method which add contracts to car.
		 * 
		 * @param List
		 *            as contracts for car.
		 * @return contracts of car.
		 */
		public CarTOBuilder withAttendantEmployees(List<Long> attendantEmployees) {
			this.attendantEmployees = attendantEmployees;
			return this;

		}

		/**
		 * This is the method which add attendant employees to car.
		 * 
		 * @param List
		 *            as attendant employees for car.
		 * @return attendant employees of car.
		 */
		public CarTOBuilder withContracts(List<Long> contracts) {
			this.contracts = contracts;
			return this;

		}

		/**
		 * This is the method which build car entity and if there is no demanded
		 * params throw exception.
		 * 
		 * @param Obligatory
		 *            String brand and String model.
		 * @return Car TO.
		 */
		public CarTO build() {
			if (brand == null || model == null) {
				throw new InvalidCreationException("Incorrect car to be created");
			}
			return new CarTO(this);
		}

	}

}
