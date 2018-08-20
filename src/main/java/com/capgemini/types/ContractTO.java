package com.capgemini.types;

import java.time.LocalDate;

import exception.InvalidCreationException;

public class ContractTO {

	private Long id;
	private LocalDate rentDate;
	private LocalDate returnDate;
	private Double cost;
	private Long departmentFromId;
	private Long departmentToId;
	private Long carTOId;
	private Long customerTOId;

	public ContractTO() {
	}

	public ContractTO(ContractTOBuilder builder) {
		this.id = builder.id;
		this.rentDate = builder.rentDate;
		this.returnDate = builder.returnDate;
		this.cost = builder.cost;
		this.departmentFromId = builder.departmentFromId;
		this.departmentToId = builder.departmentToId;
		this.carTOId = builder.carTOId;
		this.customerTOId = builder.customerTOId;

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

	public Long getDepartmentFromId() {
		return departmentFromId;
	}

	public void setDepartmentFromId(Long departmentFromId) {
		this.departmentFromId = departmentFromId;
	}

	public Long getDepartmentToId() {
		return departmentToId;
	}

	public void setDepartmentToId(Long departmentToId) {
		this.departmentToId = departmentToId;
	}

	public Long getCarTOId() {
		return carTOId;
	}

	public void setCarTOId(Long carTOId) {
		this.carTOId = carTOId;
	}

	public Long getCustomerTOId() {
		return customerTOId;
	}

	public void setCustomerTOId(Long customerTOId) {
		this.customerTOId = customerTOId;
	}

	public static ContractTOBuilder builder() {
		return new ContractTOBuilder();
	}

	public static class ContractTOBuilder {
		private Long id;
		private LocalDate rentDate;
		private LocalDate returnDate;
		private Double cost;
		private Long departmentFromId;
		private Long departmentToId;
		private Long carTOId;
		private Long customerTOId;

		/**
		 * Default constructor for car contract TO builder.
		 *
		 */
		public ContractTOBuilder() {

		}

		/**
		 * This is the method which add id to contract.
		 * 
		 * @param Long
		 *            as id for contract.
		 * @return Id of contract.
		 */
		public ContractTOBuilder withId(Long id) {
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
		public ContractTOBuilder withRentDate(LocalDate rentDate) {
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
		public ContractTOBuilder withReturnDate(LocalDate returnDate) {
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
		public ContractTOBuilder withCost(Double cost) {
			this.cost = cost;
			return this;

		}

		/**
		 * This is the method which add department to contract.
		 * 
		 * @param Long
		 *            as department id for contract.
		 * @return Department of contract.
		 */
		public ContractTOBuilder withDepartmentFromId(Long departmentFromId) {
			this.departmentFromId = departmentFromId;
			return this;

		}

		/**
		 * This is the method which add brand to contract.
		 * 
		 * @param Long
		 *            as department id for contract.
		 * @return Department of contract.
		 */
		public ContractTOBuilder withDepartmentToId(Long departmentToId) {
			this.departmentToId = departmentToId;
			return this;

		}

		/**
		 * This is the method which add car to contract.
		 * 
		 * @param Long
		 *            as car id for contract.
		 * @return Car of contract.
		 */
		public ContractTOBuilder withCarId(Long carTOId) {
			this.carTOId = carTOId;
			return this;

		}

		/**
		 * This is the method which add customer to contract.
		 * 
		 * @param Long
		 *            as customer id for contract.
		 * @return Customer entity.
		 */
		public ContractTOBuilder withCustomerId(Long customerTOId) {
			this.customerTOId = customerTOId;
			return this;

		}

		/**
		 * This is the method which build contract TO and if there is no
		 * demanded params throw exception.
		 * 
		 * @param Obligatory
		 *            Date rent date and Date return date.
		 * @return Contract entity.
		 */
		public ContractTO build() {
			if (rentDate == null || returnDate == null) {
				throw new InvalidCreationException("Incorrect contract to be created");
			}
			return new ContractTO(this);
		}
	}
}