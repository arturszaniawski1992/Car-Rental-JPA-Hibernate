package com.capgemini.types;

import java.util.List;

import embedded.AdressDataEntity;

public class DepartmentTO {

	private String mobile;
	private AdressDataEntity adressData;
	private List<Long> employees;
	private List<Long> contractFrom;
	private List<Long> contractTo;

	public DepartmentTO() {
		super();
	}

	public DepartmentTO(DepartmentTOBuilder builder) {
		this.mobile = builder.mobile;
		this.adressData = builder.adressData;
		this.employees = builder.employees;
		this.contractFrom = builder.contractFrom;
		this.contractTo = builder.contractTo;

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

		private String mobile;
		private AdressDataEntity adressData;
		private List<Long> employees;
		private List<Long> contractFrom;
		private List<Long> contractTo;

		public DepartmentTOBuilder() {
			super();

		}

		public DepartmentTOBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		public DepartmentTOBuilder withAdressData(AdressDataEntity adressData) {
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
