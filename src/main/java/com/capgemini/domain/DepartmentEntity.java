package com.capgemini.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.capgemini.listeners.InsertListener;
import com.capgemini.listeners.UpdateListener;

import embedded.AdressDataEntity;
import exception.InvalidCreationException;

@Entity
@Table(name = "department")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({ UpdateListener.class, InsertListener.class })
public class DepartmentEntity extends AbstractEntity implements Serializable {

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
	@OneToMany(mappedBy = "departmentFrom", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ContractEntity> contractFrom;
	@OneToMany(mappedBy = "departmentTo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ContractEntity> contractTo;

	/**
	 * Default constructor for department entity.
	 *
	 */
	public DepartmentEntity() {
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

		/**
		 * Default constructor for department entity builder.
		 *
		 */
		public DepartmentEntityBuilder() {
		}

		/**
		 * This is the method which add id to department.
		 * 
		 * @param Long
		 *            as id for department.
		 * @return id of department.
		 */
		public DepartmentEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		/**
		 * This is the method which add mobile to department.
		 * 
		 * @param String
		 *            as mobile for department.
		 * @return mobile of department.
		 */
		public DepartmentEntityBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		/**
		 * This is the method which add adress to department.
		 * 
		 * @param AdressDataEntity
		 *            as adress for department.
		 * @return adress of department.
		 */
		public DepartmentEntityBuilder withAdressData(AdressDataEntity adressData) {
			this.adressData = adressData;
			return this;
		}

		/**
		 * This is the method which add employees to department.
		 * 
		 * @param List
		 *            as employees for department.
		 * @return employees of department.
		 */
		public DepartmentEntityBuilder withEmployees(List<EmployeeEntity> employees) {
			this.employees = employees;
			return this;
		}

		/**
		 * This is the method which add contracts to department.
		 * 
		 * @param List
		 *            as contracts for department.
		 * @return contract of department.
		 */
		public DepartmentEntityBuilder withContractFrom(List<ContractEntity> contractFrom) {
			this.contractFrom = contractFrom;
			return this;
		}

		/**
		 * This is the method which add contracts to department.
		 * 
		 * @param List
		 *            as contracts for department.
		 * @return contract of department.
		 */
		public DepartmentEntityBuilder withContractTo(List<ContractEntity> contractTo) {
			this.contractTo = contractTo;
			return this;
		}

		/**
		 * This is the method which build department entity and if there is no
		 * demanded params throw exception.
		 * 
		 * @param Obligatory
		 *            String mobile, adressData adress.
		 * @return Department entity.
		 */
		public DepartmentEntity build() {
			if (mobile == null || adressData == null) {
				throw new InvalidCreationException("Incorrect department to be created");
			}
			return new DepartmentEntity(this);
		}

	}

}
