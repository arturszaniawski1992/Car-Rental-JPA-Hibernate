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
	private Integer power;
	@Column(name = "milleage", nullable = false)
	private Integer milleage;
	@Column(name = "engineCapacity", length = 50, nullable = false)
	private Double engineCapacity;
	@Column(name = "year", nullable = false)
	private Integer year;
	@Column(name = "color", nullable = false)
	private String color;
	@Column(name = "car_type", nullable = false)
	private String type;

	@OneToMany(mappedBy = "carEntity", cascade = CascadeType.ALL)
	private List<ContractEntity> contracts;
	@ManyToMany(mappedBy = "attendCars", cascade = CascadeType.ALL)
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

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public Integer getPower() {
		return power;
	}

	public Integer getMilleage() {
		return milleage;
	}

	public Double getEngineCapacity() {
		return engineCapacity;
	}

	public Integer getYear() {
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
		private Integer power;
		private Integer milleage;
		private Double engineCapacity;
		private Integer year;
		private String color;
		private String type;
		private List<ContractEntity> contracts;
		private List<EmployeeEntity> attendantEmployees;

		public CarEntityBuilder() {

		}

		public CarEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public CarEntityBuilder withBrand(String brand) {
			this.brand = brand;
			return this;
		}

		public CarEntityBuilder withModel(String model) {
			this.model = model;
			return this;
		}

		public CarEntityBuilder withPower(Integer power) {
			this.power = power;
			return this;
		}

		public CarEntityBuilder withMilleage(Integer milleage) {
			this.milleage = milleage;
			return this;

		}

		public CarEntityBuilder withEngineCapacity(Double engineCapacity) {
			this.engineCapacity = engineCapacity;
			return this;

		}

		public CarEntityBuilder withYear(Integer year) {
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
			return new CarEntity(this);
		}

	}
}
