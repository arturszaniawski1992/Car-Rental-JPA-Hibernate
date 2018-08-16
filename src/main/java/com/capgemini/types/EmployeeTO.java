package com.capgemini.types;

import java.time.LocalDate;

public class EmployeeTO {

	private Long id;
	private String firstName;
	private String lastName;
	private Double salary;
	private LocalDate dateOfBirth;
	private String mobile;

	EmployeeTO() {
		super();
	}

	public EmployeeTO(EmployeeTOBuilder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.salary = builder.salary;
		this.dateOfBirth = builder.dateOfBirth;
		this.mobile = builder.mobile;

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

	public double getSalary() {
		return salary;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getMobile() {
		return mobile;
	}

	public static class EmployeeTOBuilder {

		private Long id;
		private String firstName;
		private String lastName;
		private Double salary;
		private LocalDate dateOfBirth;
		private String mobile;

		public EmployeeTOBuilder() {
			super();
		}

		public EmployeeTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public EmployeeTOBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public EmployeeTOBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public EmployeeTOBuilder withSalary(double salary) {
			this.salary = salary;
			return this;
		}

		public EmployeeTOBuilder withDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public EmployeeTOBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		public EmployeeTO build() {
			return new EmployeeTO(this);
		}

	}

}
