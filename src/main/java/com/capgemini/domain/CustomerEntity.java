package com.capgemini.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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
@Table(name = "customer")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({ UpdateListener.class, InsertListener.class })
public class CustomerEntity extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 50)
	private String firstName;
	@Column(nullable = false, length = 50)
	private String lastName;
	@Column(nullable = false)
	private String creditCardNumber;
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	@Column(length = 50)
	private String mobile;
	@Column(length = 50)
	private String mail;
	@Embedded
	private AdressDataEntity adressData;

	@OneToMany(mappedBy = "customerEntity")
	private List<ContractEntity> contracts;

	/**
	 * Default constructor for customer entity.
	 *
	 */
	public CustomerEntity() {
	}

	public CustomerEntity(CustomerEntityBuilder builder) {
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

	public AdressDataEntity getAdressData() {
		return adressData;
	}

	public List<ContractEntity> getContracts() {
		return contracts;
	}

	public static CustomerEntityBuilder builder() {
		return new CustomerEntityBuilder();
	}

	public static class CustomerEntityBuilder {
		private Long id;
		private String firstName;
		private String lastName;
		private String creditCardNumber;
		private LocalDate dateOfBirth;
		private String mobile;
		private String mail;
		private AdressDataEntity adressData;
		private List<ContractEntity> contracts;

		/**
		 * Default constructor for customer entity builder.
		 *
		 */
		public CustomerEntityBuilder() {
		}

		/**
		 * This is the method which add id to customer.
		 * 
		 * @param Long
		 *            as id for customer.
		 * @return Id of customer.
		 */
		public CustomerEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		/**
		 * This is the method which add first name to customer.
		 * 
		 * @param String
		 *            as first name of customer.
		 * @return first name of customer.
		 */
		public CustomerEntityBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		/**
		 * This is the method which add last name to customer.
		 * 
		 * @param String
		 *            as last name of customer.
		 * @return last name of customer.
		 */
		public CustomerEntityBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		/**
		 * This is the method which add credit card number to customer.
		 * 
		 * @param String
		 *            as credit card number.
		 * @return credit card number of customer.
		 */
		public CustomerEntityBuilder withCreditCardNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
			return this;
		}

		/**
		 * This is the method which add date of birth to customer.
		 * 
		 * @param LocalDate
		 *            as date of birth of customer.
		 * @return date of birth of customer.
		 */
		public CustomerEntityBuilder withDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		/**
		 * This is the method which add mobile to customer.
		 * 
		 * @param String
		 *            as mobile of customer.
		 * @return mobile of customer.
		 */
		public CustomerEntityBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		/**
		 * This is the method which add adress to customer.
		 * 
		 * @param AdressDataEntity
		 *            as adress for customer.
		 * @return adress of customer.
		 */
		public CustomerEntityBuilder withAdressData(AdressDataEntity adressData) {
			this.adressData = adressData;
			return this;
		}

		/**
		 * This is the method which add contracts to customer.
		 * 
		 * @param List
		 *            as contracts for customer.
		 * @return contracts of customer.
		 */
		public CustomerEntityBuilder withContracts(List<ContractEntity> contracts) {
			this.contracts = contracts;
			return this;
		}

		/**
		 * This is the method which build customer entity and if there is no
		 * demanded params throw exception.
		 * 
		 * @param Obligatory
		 *            String firstname, String lastname, String mobile,.
		 * @return Customer entity.
		 */
		public CustomerEntity build() {
			if (firstName == null || lastName == null || mobile == null) {
				throw new InvalidCreationException("Incorrect customer to be created");
			}

			return new CustomerEntity(this);
		}

	}
}
