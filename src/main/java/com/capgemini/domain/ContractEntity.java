package com.capgemini.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contract")
public class ContractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "rent_date", nullable = false)
	private LocalDate rentDate;
	@Column(name = "return_date", nullable = false)
	private LocalDate returnDate;
	@Column(name = "cost", nullable = false)
	private double cost;

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

	public ContractEntity() {
	}

	public ContractEntity(ContractEntityBuilder builder) {
		this.rentDate = builder.rentDate;
		this.returnDate = builder.returnDate;
		this.cost = builder.cost;
		this.departmentFrom = builder.departmentFrom;
		this.departmentTo = builder.departmentTo;
		this.carEntity = builder.carEntity;
		this.customerEntity = builder.customerEntity;
	}

	public LocalDate getRentDate() {
		return rentDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public double getCost() {
		return cost;
	}

	public DepartmentEntity getDepartmentFrom() {
		return departmentFrom;
	}

	public DepartmentEntity getDepartmentTo() {
		return departmentTo;
	}

	public CarEntity getCarEntity() {
		return carEntity;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public static class ContractEntityBuilder {
		private LocalDate rentDate;
		private LocalDate returnDate;
		private double cost;
		private DepartmentEntity departmentFrom;
		private DepartmentEntity departmentTo;
		private CarEntity carEntity;
		private CustomerEntity customerEntity;

		public ContractEntityBuilder() {

		}

		public ContractEntityBuilder withRentDate(LocalDate rentDate){
			this.rentDate=rentDate;
			return this;
			
		}
		
		public ContractEntityBuilder withReturnDate(LocalDate returnDate){
			this.returnDate=returnDate;
			return this;
			
		}
		
		public ContractEntityBuilder withCost(double cost){
			this.cost=cost;
			return this;
			
		}
		
		public ContractEntityBuilder withDepartmentFrom(DepartmentEntity departmentFrom){
			this.departmentFrom=departmentFrom;
			return this;
			
		}
		
		public ContractEntityBuilder withDepartmentTo(DepartmentEntity departmentTo){
			this.departmentTo=departmentTo;
			return this;
			
		}
		
		public ContractEntityBuilder withCarEntity(CarEntity carEntity){
			this.carEntity=carEntity;
			return this;
			
		}
		
		public ContractEntityBuilder withDepartmentTo(CustomerEntity customerEntity){
			this.customerEntity=customerEntity;
			return this;
			
		}
		
		
		public ContractEntity build() {
			return new ContractEntity(this);
		}
	}

}
