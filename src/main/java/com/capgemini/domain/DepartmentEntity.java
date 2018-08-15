package com.capgemini.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import embedded.AdressData;

@Entity
@Table(name = "department")
public class DepartmentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 15, nullable = false)
	private String mobile;
	@Embedded
	private AdressData adressData;

	@OneToMany(mappedBy = "departmentEntity")
	private List<EmployeeEntity> employees;
	@OneToMany(mappedBy = "departmentFrom", cascade = CascadeType.ALL)
	private List<ContractEntity> contractFrom;
	@OneToMany(mappedBy = "departmentTo", cascade = CascadeType.ALL)
	private List<ContractEntity> contractTo;

	public DepartmentEntity() {
		super();
	}

	public DepartmentEntity(DepartmentEntityBuilder builder) {

		this.mobile = builder.mobile;
		this.adressData = builder.adressData;
		this.employees = builder.employees;
		this.contractFrom = builder.contractFrom;
		this.contractTo = builder.contractTo;
	}

	public String getMobile() {
		return mobile;
	}

	public AdressData getAdressData() {
		return adressData;
	}

	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public List<ContractEntity> getContractFrom() {
		return contractFrom;
	}

	public List<ContractEntity> getContractTo() {
		return contractTo;
	}

	public static DepartmentEntityBuilder builder() {
		return new DepartmentEntityBuilder();
	}

	public static class DepartmentEntityBuilder {
		private String mobile;
		private AdressData adressData;
		private List<EmployeeEntity> employees;
		private List<ContractEntity> contractFrom;
		private List<ContractEntity> contractTo;

		public DepartmentEntityBuilder() {
			super();
		}

		public DepartmentEntityBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		public DepartmentEntityBuilder withAdress(AdressData adressData) {
			this.adressData = adressData;
			return this;
		}

		public DepartmentEntityBuilder withEmployees(List<EmployeeEntity> employees) {
			this.employees = employees;
			return this;
		}

		public DepartmentEntityBuilder withContractFrom(List<ContractEntity> contractFrom) {
			this.contractFrom = contractFrom;
			return this;
		}

		public DepartmentEntityBuilder withContractTo(List<ContractEntity> contractTo) {
			this.contractTo=contractTo;
			return this;
		}

		public DepartmentEntity build() {
			return new DepartmentEntity(this);
		}

	}

}
