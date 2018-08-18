package com.capgemini.types;

import java.util.List;

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

		public CarTOBuilder() {
			super();

		}

		public CarTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public CarTOBuilder withBrand(String brand) {
			this.brand = brand;
			return this;
		}

		public CarTOBuilder withModel(String model) {
			this.model = model;
			return this;
		}

		public CarTOBuilder withPower(Integer power) {
			this.power = power;
			return this;
		}

		public CarTOBuilder withMilleage(Integer milleage) {
			this.milleage = milleage;
			return this;

		}

		public CarTOBuilder withEngineCapacity(Double engineCapacity) {
			this.engineCapacity = engineCapacity;
			return this;

		}

		public CarTOBuilder withYear(Integer year) {
			this.year = year;
			return this;

		}

		public CarTOBuilder withColor(String color) {
			this.color = color;
			return this;

		}

		public CarTOBuilder withType(String type) {
			this.type = type;
			return this;

		}

		public CarTOBuilder withAttendantEmployees(List<Long> attendantEmployees) {
			this.attendantEmployees = attendantEmployees;
			return this;

		}

		public CarTOBuilder withContracts(List<Long> contracts) {
			this.contracts = contracts;
			return this;

		}

		public CarTO build() {

			return new CarTO(this);
		}

	}

}
