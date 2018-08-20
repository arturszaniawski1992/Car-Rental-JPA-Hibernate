package com.capgemini.types;

import java.util.List;

import exception.InvalidCreationException;

public class DepartmentTO {
	private Long id;
	private String mobile;
	private AdressDataTO adressData;
	private List<Long> employees;
	private List<Long> contractFrom;
	private List<Long> contractTo;

	public DepartmentTO() {
		super();
	}

	public DepartmentTO(DepartmentTOBuilder builder) {
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

	public AdressDataTO getAdressData() {
		return adressData;
	}

	public void setAdressData(AdressDataTO adressData) {
		this.adressData = adressData;
	}

	public List<Long> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Long> employees) {
		this.employees = employees;
	}

	public List<Long> getContractFrom() {
		return contractFrom;
	}

	public void setContractFrom(List<Long> contractFrom) {
		this.contractFrom = contractFrom;
	}

	public List<Long> getContractTo() {
		return contractTo;
	}

	public void setContractTo(List<Long> contractTo) {
		this.contractTo = contractTo;
	}

	public static DepartmentTOBuilder builder() {
		return new DepartmentTOBuilder();
	}

	public static class DepartmentTOBuilder {
		private Long id;
		private String mobile;
		private AdressDataTO adressData;
		private List<Long> employees;
		private List<Long> contractFrom;
		private List<Long> contractTo;

		/**
		 * Default constructor for department TO builder.
		 *
		 */
		public DepartmentTOBuilder() {
			super();

		}

		/**
		 * This is the method which add id to department.
		 * 
		 * @param Long
		 *            as id for department.
		 * @return id of department.
		 */
		public DepartmentTOBuilder withId(Long id) {
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
		public DepartmentTOBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		/**
		 * This is the method which add adress to department.
		 * 
		 * @param AdressDataTO
		 *            as adress for department.
		 * @return adress of department.
		 */
		public DepartmentTOBuilder withAdressData(AdressDataTO adressData) {
			this.adressData = adressData;
			return this;
		}

		/**
		 * This is the method which add employees to department.
		 * 
		 * @param List
		 *            as employees id for department.
		 * @return employees of department.
		 */
		public DepartmentTOBuilder withEmployees(List<Long> employees) {
			this.employees = employees;
			return this;
		}

		/**
		 * This is the method which add contracts to department.
		 * 
		 * @param List
		 *            as contracts id for department.
		 * @return contract of department.
		 */
		public DepartmentTOBuilder withContractFrom(List<Long> contractFrom) {
			this.contractFrom = contractFrom;
			return this;
		}

		/**
		 * This is the method which add contracts to department.
		 * 
		 * @param List
		 *            as contracts id for department.
		 * @return contract of department.
		 */
		public DepartmentTOBuilder withContractTo(List<Long> contractTo) {
			this.contractTo = contractTo;
			return this;
		}

		/**
		 * This is the method which build department TO and if there is no
		 * demanded params throw exception.
		 * 
		 * @param Obligatory
		 *            String mobile, adressData adress.
		 * @return Department entity.
		 */
		public DepartmentTO build() {
			if (mobile == null || adressData == null) {
				throw new InvalidCreationException("Incorrect department to be created");
			}
			return new DepartmentTO(this);
		}

	}
}
