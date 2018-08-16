package com.capgemini.types;

import embedded.AdressData;

public class DepartmentTO {

	private String mobile;
	private AdressData adressData;

	public DepartmentTO() {
		super();
	}

	public DepartmentTO(DepartmentTOBuilder builder) {
		this.mobile = builder.mobile;
		this.adressData = builder.adressData;

	}

	public String getMobile() {
		return mobile;
	}

	public AdressData getAdressData() {
		return adressData;
	}

	public static DepartmentTOBuilder builder() {
		return new DepartmentTOBuilder();
	}

	public static class DepartmentTOBuilder {

		private String mobile;
		private AdressData adressData;

		public DepartmentTOBuilder() {
			super();

		}

		public DepartmentTOBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		public DepartmentTOBuilder withAdressData(AdressData adressData) {
			this.adressData = adressData;
			return this;
		}

		public DepartmentTO build() {
			return new DepartmentTO(this);
		}

	}
}
