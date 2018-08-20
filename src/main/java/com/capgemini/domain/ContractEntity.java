package com.capgemini.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.listeners.InsertListener;
import com.capgemini.listeners.UpdateListener;

import exception.InvalidCreationException;

@Entity
@Table(name = "contract")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({ UpdateListener.class, InsertListener.class })
public class ContractEntity extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "rent_date", nullable = false)
	private LocalDate rentDate;
	@Column(name = "return_date", nullable = false)
	private LocalDate returnDate;
	@Column(name = "cost", nullable = false)
	private Double cost;

	@ManyToOne
	@JoinColumn(name = "id_department_from")
	private DepartmentEntity departmentFrom;
	@ManyToOne
	@JoinColumn(name = "id_department_to")
	private DepartmentEntity departmentTo;
	@ManyToOne
	@JoinColumn(name = "id_car")
	private CarEntity carEntity;
	@ManyToOne
	@JoinColumn(name = "id_customer")
	private CustomerEntity customerEntity;

	/**
	 * Default constructor for car contract entity.
	 *
	 */
	public ContractEntity() {
	}

	public ContractEntity(ContractEntityBuilder builder) {
		this.id = builder.id;
		this.rentDate = builder.rentDate;
		this.returnDate = builder.returnDate;
		this.cost = builder.cost;
		this.departmentFrom = builder.departmentFrom;
		this.departmentTo = builder.departmentTo;
		this.carEntity = builder.carEntity;
		this.customerEntity = builder.customerEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getRentDate() {
		return rentDate;
	}

	public void setRentDate(LocalDate rentDate) {
		this.rentDate = rentDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public DepartmentEntity getDepartmentFrom() {
		return departmentFrom;
	}

	public void setDepartmentFrom(DepartmentEntity departmentFrom) {
		this.departmentFrom = departmentFrom;
	}

	public DepartmentEntity getDepartmentTo() {
		return departmentTo;
	}

	public void setDepartmentTo(DepartmentEntity departmentTo) {
		this.departmentTo = departmentTo;
	}

	public CarEntity getCarEntity() {
		return carEntity;
	}

	public void setCarEntity(CarEntity carEntity) {
		this.carEntity = carEntity;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	public static ContractEntityBuilder builder() {
		return new ContractEntityBuilder();
	}

	public static class ContractEntityBuilder {
		private Long id;
		private LocalDate rentDate;
		private LocalDate returnDate;
		private Double cost;
		private DepartmentEntity departmentFrom;
		private DepartmentEntity departmentTo;
		private CarEntity carEntity;
		private CustomerEntity customerEntity;

		/**
		 * Default constructor for car contract entity builder.
		 *
		 */
		public ContractEntityBuilder() {

		}

		/**
		 * This is the method which add id to contract.
		 * 
		 * @param Long
		 *            as id for contract.
		 * @return Id of contract.
		 */
		public ContractEntityBuilder withId(Long id) {
			this.id = id;
			return this;

		}

		/**
		 * This is the method which add date to contract.
		 * 
		 * @param LocalDate
		 *            as date of rent for contract.
		 * @return rent date of contract.
		 */
		public ContractEntityBuilder withRentDate(LocalDate rentDate) {
			this.rentDate = rentDate;
			return this;

		}

		/**
		 * This is the method which add date to contract.
		 * 
		 * @param LocalDate
		 *            as date of return for contract.
		 * @return return date of contract.
		 */
		public ContractEntityBuilder withReturnDate(LocalDate returnDate) {
			this.returnDate = returnDate;
			return this;

		}

		/**
		 * This is the method which add cost to contract.
		 * 
		 * @param Double
		 *            as cost for contract.
		 * @return cost of contract.
		 */
		public ContractEntityBuilder withCost(Double cost) {
			this.cost = cost;
			return this;

		}

		/**
		 * This is the method which add brand to contract.
		 * 
		 * @param DepartmentEntity
		 *            as department for contract.
		 * @return Department of contract.
		 */
		public ContractEntityBuilder withDepartmentFrom(DepartmentEntity departmentFrom) {
			this.departmentFrom = departmentFrom;
			return this;

		}

		/**
		 * This is the method which add brand to contract.
		 * 
		 * @param DepartmentEntity
		 *            as department for contract.
		 * @return Department of contract.
		 */
		public ContractEntityBuilder withDepartmentTo(DepartmentEntity departmentTo) {
			this.departmentTo = departmentTo;
			return this;

		}

		/**
		 * This is the method which add car to contract.
		 * 
		 * @param CarEntity
		 *            as car for contract.
		 * @return Car entity of contract.
		 */
		public ContractEntityBuilder withCar(CarEntity carEntity) {
			this.carEntity = carEntity;
			return this;

		}

		/**
		 * This is the method which add customer to contract.
		 * 
		 * @param CustomerEntity
		 *            as customer for contract.
		 * @return Customer entity.
		 */
		public ContractEntityBuilder withCustomer(CustomerEntity customerEntity) {
			this.customerEntity = customerEntity;
			return this;

		}

		/**
		 * This is the method which build contract entity and if there is no
		 * demanded params throw exception.
		 * 
		 * @param Obligatory
		 *            Date rent date and Date return date.
		 * @return Contract entity.
		 */
		public ContractEntity build() {
			if (rentDate == null || returnDate == null) {
				throw new InvalidCreationException("Incorrect contract to be created");
			}
			return new ContractEntity(this);
		}
	}

}
