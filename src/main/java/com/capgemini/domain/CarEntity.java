package com.capgemini.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class CarEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "brand", length = 50, nullable = false)
	private String brand;
	@Column(name = "model", length = 50, nullable = false)
	private String model;
	@Column(name = "power", nullable = false)
	private int power;
	@Column(name = "milleage", nullable = false)
	private int milleage;
	@Column(name = "engineCapacity", length = 50, nullable = false)
	private int engineCapacity;
	@Column(name = "year", nullable = false)
	private int year;
	@Column(name = "color", nullable = false)
	private String color;
	@Column(name = "car_type", nullable = false)
	private String type;

	@OneToMany(mappedBy = "carEntity", cascade = CascadeType.ALL)
	private List<ContractEntity> contracts;
	@ManyToMany(mappedBy = "attendCars", cascade = CascadeType.MERGE)
	private List<EmployeeEntity> attendantEmployees;

	public CarEntity() {
		super();
	}

	public CarEntity(CarEntityBuilder builder) {
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

	public List<ContractEntity> getContracts() {
		return contracts;
	}
	
	public List<EmployeeEntity> getAttendantEmployees() {
		return attendantEmployees;
	}

	public static CarEntityBuilder builder() {
		return new CarEntityBuilder();
	}

	public static class CarEntityBuilder {
		private Long id;
		private String brand;
		private String model;
		private int power;
		private int milleage;
		private int engineCapacity;
		private int year;
		private String color;
		private String type;
		private List<ContractEntity> contracts;
		private List<EmployeeEntity> attendantEmployees;

		public CarEntityBuilder() {
			
		}

		public CarEntityBuilder withBrand(String brand) {
			this.brand = brand;
			return this;
		}

		public CarEntityBuilder withModel(String model) {
			this.model = model;
			return this;
		}

		public CarEntityBuilder withPower(int power) {
			this.power = power;
			return this;
		}

		public CarEntityBuilder withMilleage(int milleage) {
			this.milleage = milleage;
			return this;

		}

		public CarEntityBuilder withEngineCapacity(int engineCapacity) {
			this.engineCapacity = engineCapacity;
			return this;

		}

		public CarEntityBuilder withYear(int year) {
			this.year = year;
			return this;

		}

		public CarEntityBuilder withColor(String color) {
			this.color = color;
			return this;

		}

		public CarEntityBuilder withType(String type) {
			this.type = type;
			return this;

		}

		public CarEntityBuilder withContracts(List<ContractEntity> contracts) {
			this.contracts = contracts;
			return this;

		}

		public CarEntityBuilder withAttendantEmployees(List<EmployeeEntity> attendantEmployees) {
			this.attendantEmployees = attendantEmployees;
			return this;

		}

		public CarEntity build() {
			if (brand != null || model != null) {
				throw new RuntimeException("Incorrect car to be created");
			}
			return new CarEntity(this);
		}

	}
}
