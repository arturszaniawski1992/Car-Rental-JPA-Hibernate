package com.capgemini.types;

import java.util.List;

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

		public DepartmentTOBuilder() {
			super();

		}

		public DepartmentTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public DepartmentTOBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		public DepartmentTOBuilder withAdressData(AdressDataTO adressData) {
			this.adressData = adressData;
			return this;
		}

		public DepartmentTOBuilder withEmployees(List<Long> employees) {
			this.employees = employees;
			return this;
		}

		public DepartmentTOBuilder withContractFrom(List<Long> contractFrom) {
			this.contractFrom = contractFrom;
			return this;
		}

		public DepartmentTOBuilder withContractTo(List<Long> contractTo) {
			this.contractTo = contractTo;
			return this;
		}

		public DepartmentTO build() {
			return new DepartmentTO(this);
		}

	}
}
