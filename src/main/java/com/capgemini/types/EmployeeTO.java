package com.capgemini.types;

import java.time.LocalDate;
import java.util.List;

public class EmployeeTO {

	private Long id;
	private String firstName;
	private String lastName;
	private Double salary;
	private LocalDate dateOfBirth;
	private String mobile;
	private DepartmentTO departmentTO;
	private PositionTO positionTO;
	private List<Long> attendCars;

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
		this.attendCars = builder.attendCars;

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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
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

	public DepartmentTO getDepartmentTO() {
		return departmentTO;
	}

	public void setDepartmentTO(DepartmentTO departmentTO) {
		this.departmentTO = departmentTO;
	}

	public PositionTO getPositionTO() {
		return positionTO;
	}

	public void setPositionTO(PositionTO positionTO) {
		this.positionTO = positionTO;
	}

	public List<Long> getAttendCars() {
		return attendCars;
	}

	public void setAttendCars(List<Long> attendCars) {
		this.attendCars = attendCars;
	}

	public static class EmployeeTOBuilder {

		private Long id;
		private String firstName;
		private String lastName;
		private Double salary;
		private LocalDate dateOfBirth;
		private String mobile;
		private List<Long> attendCars;

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

		public EmployeeTOBuilder withAttendCars(List<Long> attendCars) {
			this.attendCars = attendCars;
			return this;
		}

		public EmployeeTO build() {
			return new EmployeeTO(this);
		}

	}

}
