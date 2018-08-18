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

import embedded.AdressDataEntity;

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
	private AdressDataEntity adressData;

	@OneToMany(mappedBy = "departmentEntity")
	private List<EmployeeEntity> employees;
	@OneToMany(mappedBy = "departmentFrom", cascade = CascadeType.REMOVE)
	private List<ContractEntity> contractFrom;
	@OneToMany(mappedBy = "departmentTo", cascade = CascadeType.MERGE)
	private List<ContractEntity> contractTo;

	public DepartmentEntity() {
		super();
	}

	public DepartmentEntity(DepartmentEntityBuilder builder) {
		this.id = builder.id;
		this.mobile = builder.mobile;
		this.adressData = builder.adressData;
		this.employees = builder.employees;
		this.contractFrom = builder.contractFrom;
		this.contractTo = builder.contractTo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public AdressDataEntity getAdressData() {
		return adressData;
	}

	public void setAdressData(AdressDataEntity adressData) {
		this.adressData = adressData;
	}

	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	public List<ContractEntity> getContractFrom() {
		return contractFrom;
	}

	public void setContractFrom(List<ContractEntity> contractFrom) {
		this.contractFrom = contractFrom;
	}

	public List<ContractEntity> getContractTo() {
		return contractTo;
	}

	public void setContractTo(List<ContractEntity> contractTo) {
		this.contractTo = contractTo;
	}

	public static DepartmentEntityBuilder builder() {
		return new DepartmentEntityBuilder();
	}

	public static class DepartmentEntityBuilder {
		private Long id;
		private String mobile;
		private AdressDataEntity adressData;
		private List<EmployeeEntity> employees;
		private List<ContractEntity> contractFrom;
		private List<ContractEntity> contractTo;

		public DepartmentEntityBuilder() {
			super();
		}

		public DepartmentEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public DepartmentEntityBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		public DepartmentEntityBuilder withAdressData(AdressDataEntity adressData) {
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
			this.contractTo = contractTo;
			return this;
		}

		public DepartmentEntity build() {
			return new DepartmentEntity(this);
		}

	}

}
