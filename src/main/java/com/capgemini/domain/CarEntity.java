package com.capgemini.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.capgemini.listeners.InsertListener;
import com.capgemini.listeners.UpdateListener;

import exception.InvalidCreationException;

@Entity
@Table(name = "car")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({ UpdateListener.class, InsertListener.class })
public class CarEntity extends AbstractEntity implements Serializable {

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
	@Column(name = "power")
	private Integer power;
	@Column(name = "milleage")
	private Integer milleage;
	@Column(name = "engineCapacity", length = 50)
	private Double engineCapacity;
	@Column(name = "year")
	private Integer year;
	@Column(name = "color")
	private String color;
	@Column(name = "car_type", nullable = false)
	private String type;

	@OneToMany(mappedBy = "carEntity", cascade = CascadeType.REMOVE)
	private List<ContractEntity> contracts;
	@ManyToMany(mappedBy = "attendCars", cascade = CascadeType.MERGE)
	private List<EmployeeEntity> attendantEmployees;

	public CarEntity() {
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

	public List<ContractEntity> getContracts() {
		return contracts;
	}

	public void setContracts(List<ContractEntity> contracts) {
		this.contracts = contracts;
	}

	public List<EmployeeEntity> getAttendantEmployees() {
		return attendantEmployees;
	}

	public void setAttendantEmployees(List<EmployeeEntity> attendantEmployees) {
		this.attendantEmployees = attendantEmployees;
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

		/**
		 * Default constructor for car entity builder.
		 *
		 */
		public CarEntityBuilder() {

		}

		/**
		 * This is the method which add id to car.
		 * 
		 * @param Long
		 *            as id for car.
		 * @return Id of car.
		 */
		public CarEntityBuilder withId(Long id) {
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
		public CarEntityBuilder withBrand(String brand) {
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
		public CarEntityBuilder withModel(String model) {
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
		public CarEntityBuilder withPower(Integer power) {
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
		public CarEntityBuilder withMilleage(Integer milleage) {
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
		public CarEntityBuilder withEngineCapacity(Double engineCapacity) {
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
		public CarEntityBuilder withYear(Integer year) {
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
		public CarEntityBuilder withColor(String color) {
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
		public CarEntityBuilder withType(String type) {
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
		public CarEntityBuilder withContracts(List<ContractEntity> contracts) {
			this.contracts = contracts;
			return this;

		}

		/**
		 * This is the method which add attendant employees to car.
		 * 
		 * @param List
		 *            as attendant employees for car.
		 * @return attendant employees of car.
		 */
		public CarEntityBuilder withAttendantEmployees(List<EmployeeEntity> attendantEmployees) {
			this.attendantEmployees = attendantEmployees;
			return this;

		}

		/**
		 * This is the method which build car entity and if there is no demanded
		 * params throw exception.
		 * 
		 * @param Obligatory
		 *            String brand and String model.
		 * @return Car enity.
		 */
		public CarEntity build() {
			if (brand == null || model == null) {
				throw new InvalidCreationException("Incorrect car to be created");
			}
			return new CarEntity(this);
		}

	}
}
