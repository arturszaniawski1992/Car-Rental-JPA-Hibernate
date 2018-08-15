package com.capgemini.types;

import java.util.List;

public class CarTO {

	private Long id;
	private String brand;
	private String model;
	private int power;
	private int milleage;
	private int engineCapacity;
	private int year;
	private String color;
	private String type;
	private List<ContractTO> contracts;
	private List<EmployeeTO> attendantEmployees;

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

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public int getPower() {
		return power;
	}

	public int getMilleage() {
		return milleage;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public int getYear() {
		return year;
	}

	public String getColor() {
		return color;
	}

	public String getType() {
		return type;
	}

	public List<ContractTO> getContracts() {
		return contracts;
	}
	
	public List<EmployeeTO> getAttendantEmployees() {
		return attendantEmployees;
	}

	public static CarTOBuilder builder() {
		return new CarTOBuilder();
	}

	public static class CarTOBuilder {
		private Long id;
		private String brand;
		private String model;
		private int power;
		private int milleage;
		private int engineCapacity;
		private int year;
		private String color;
		private String type;
		private List<ContractTO> contracts;
		private List<EmployeeTO> attendantEmployees;

		public CarTOBuilder() {
			super();

		}

		public CarTOBuilder withBrand(String brand) {
			this.brand = brand;
			return this;
		}

		public CarTOBuilder withModel(String model) {
			this.model = model;
			return this;
		}

		public CarTOBuilder withPower(int power) {
			this.power = power;
			return this;
		}

		public CarTOBuilder withMilleage(int milleage) {
			this.milleage = milleage;
			return this;

		}

		public CarTOBuilder withEngineCapacity(int engineCapacity) {
			this.engineCapacity = engineCapacity;
			return this;

		}

		public CarTOBuilder withYear(int year) {
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

		public CarTOBuilder withContracts(List<ContractTO> contracts) {
			this.contracts = contracts;
			return this;

		}

		public CarTOBuilder withAttendantEmployees(List<EmployeeTO> attendantEmployees) {
			this.attendantEmployees = attendantEmployees;
			return this;

		}

		public CarTO build() {
			if (brand != null || model != null) {
				throw new RuntimeException("Incorrect car to be created");
			}
			return new CarTO(this);
		}

	}
}
