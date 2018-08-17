package com.capgemini.types;

import java.time.LocalDate;
import java.util.List;

import embedded.AdressDataEntity;

public class CustomerTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String creditCardNumber;
	private LocalDate dateOfBirth;
	private String mobile;
	private String mail;
	private AdressDataEntity adressData;
	private List<Long> contracts;

	public CustomerTO() {
		super();
	}

	public CustomerTO(CustomerTOBuilder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.creditCardNumber = builder.creditCardNumber;
		this.dateOfBirth = builder.dateOfBirth;
		this.mobile = builder.mobile;
		this.mail = builder.mail;
		this.adressData = builder.adressData;
		this.contracts = builder.contracts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public AdressDataEntity getAdressData() {
		return adressData;
	}

	public void setAdressData(AdressDataEntity adressData) {
		this.adressData = adressData;
	}

	public List<Long> getContracts() {
		return contracts;
	}

	public void setContracts(List<Long> contracts) {
		this.contracts = contracts;
	}

	public static class CustomerTOBuilder {
		private Long id;
		private String firstName;
		private String lastName;
		private String creditCardNumber;
		private LocalDate dateOfBirth;
		private String mobile;
		private String mail;
		private AdressDataEntity adressData;
		private List<Long> contracts;

		public CustomerTOBuilder() {

		}

		public CustomerTOBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public CustomerTOBuilder withCreditCardNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
			return this;
		}

		public CustomerTOBuilder withDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public CustomerTOBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		public CustomerTOBuilder withMail(String mail) {
			this.mail = mail;
			return this;
		}

		public CustomerTOBuilder withAdressData(AdressDataEntity adressData) {
			this.adressData = adressData;
			return this;
		}

		public CustomerTOBuilder withContracts(List<Long> contracts) {
			this.contracts = contracts;
			return this;
		}

		public CustomerTO build() {
			return new CustomerTO(this);
		}

	}
}
