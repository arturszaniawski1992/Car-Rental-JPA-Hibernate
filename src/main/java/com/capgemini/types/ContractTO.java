package com.capgemini.types;

import java.time.LocalDate;

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

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public Double getCost() {
		return cost;
	}

	public Long getDepartmentFromId() {
		return departmentFromId;
	}

	public Long getDepartmentToId() {
		return departmentToId;
	}

	public Long getCarEntity() {
		return carTOId;
	}

	public Long getCustomerEntityId() {
		return customerTOId;
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

		public ContractTOBuilder() {

		}

		public ContractTOBuilder withId(Long id) {
			this.id = id;
			return this;

		}

		public ContractTOBuilder withRentDate(LocalDate rentDate) {
			this.rentDate = rentDate;
			return this;

		}

		public ContractTOBuilder withReturnDate(LocalDate returnDate) {
			this.returnDate = returnDate;
			return this;

		}

		public ContractTOBuilder withCost(Double cost) {
			this.cost = cost;
			return this;

		}

		public ContractTOBuilder withDepartmentFromId(Long departmentFromId) {
			this.departmentFromId = departmentFromId;
			return this;

		}

		public ContractTOBuilder withDepartmentToId(Long departmentToId) {
			this.departmentToId = departmentToId;
			return this;

		}

		public ContractTOBuilder withCarId(Long carTOId) {
			this.carTOId = carTOId;
			return this;

		}

		public ContractTOBuilder withCustomerId(Long customerTOId) {
			this.customerTOId = customerTOId;
			return this;

		}

		public ContractTO build() {
			return new ContractTO(this);
		}
	}
}