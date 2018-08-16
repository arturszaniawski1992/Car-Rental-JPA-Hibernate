package com.capgemini.types;

import java.time.LocalDate;

import embedded.AdressData;

public class CustomerTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String creditCardNumber;
	private LocalDate dateOfBirth;
	private String mobile;
	private String mail;
	private AdressData adressData;

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

	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getMobile() {
		return mobile;
	}

	public String getMail() {
		return mail;
	}

	public AdressData getAdressData() {
		return adressData;
	}

	public static class CustomerTOBuilder {
		private Long id;
		private String firstName;
		private String lastName;
		private String creditCardNumber;
		private LocalDate dateOfBirth;
		private String mobile;
		private String mail;
		private AdressData adressData;

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

		public CustomerTOBuilder withAdressData(AdressData adressData) {
			this.adressData = adressData;
			return this;
		}

		public CustomerTO build() {
			return new CustomerTO(this);
		}

	}
}
