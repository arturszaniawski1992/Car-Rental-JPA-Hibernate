package com.capgemini.types;

import java.time.LocalDate;
import java.util.List;

import exception.InvalidCreationException;

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
	}

	public EmployeeTO(EmployeeTOBuilder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.salary = builder.salary;
		this.dateOfBirth = builder.dateOfBirth;
		this.mobile = builder.mobile;
		this.positionTO = builder.positionTO;
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
		private PositionTO positionTO;
		private List<Long> attendCars;

		/**
		 * Default constructor for employee employee TO builder.
		 *
		 */
		public EmployeeTOBuilder() {
		}

		/**
		 * This is the method which add id to employee.
		 * 
		 * @param Long
		 *            as id for employee.
		 * @return Id of employee.
		 */
		public EmployeeTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		/**
		 * This is the method which add first name to employee.
		 * 
		 * @param String
		 *            as first name of employee.
		 * @return first name of employee.
		 */
		public EmployeeTOBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		/**
		 * This is the method which add last name to employee.
		 * 
		 * @param String
		 *            as last name of employee.
		 * @return last name of employee.
		 */
		public EmployeeTOBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		/**
		 * This is the method which add salary to employee.
		 * 
		 * @param Double
		 *            as salary of employee.
		 * @return last name of employee.
		 */
		public EmployeeTOBuilder withSalary(double salary) {
			this.salary = salary;
			return this;
		}

		/**
		 * This is the method which add date of birth to employee.
		 * 
		 * @param LocalDate
		 *            as date of birth of employee.
		 * @return date of birth of employee.
		 */
		public EmployeeTOBuilder withDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		/**
		 * This is the method which add mobile to employee.
		 * 
		 * @param String
		 *            as mobile of employee.
		 * @return mobile of employee.
		 */
		public EmployeeTOBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		/**
		 * This is the method which add department to employee.
		 * 
		 * @param Long
		 *            as employees for cars.
		 * @return attendCars of employee.
		 */
		public EmployeeTOBuilder withAttendCars(List<Long> attendCars) {
			this.attendCars = attendCars;
			return this;
		}

		/**
		 * This is the method which add position to employee.
		 * 
		 * @param PositionTO
		 *            as position of employee.
		 * @return position of employee.
		 */
		public EmployeeTOBuilder withPosition(PositionTO positionTO) {
			this.positionTO = positionTO;
			return this;
		}

		/**
		 * This is the method which build employee TO and if there is no
		 * demanded params throw exception.
		 * 
		 * @param Obligatory
		 *            String firstname, String lastname, String mobile,.
		 * @return Employee entity.
		 */
		public EmployeeTO build() {
			if (firstName == null || lastName == null) {
				throw new InvalidCreationException("Incorrect employee to be created");
			}
			return new EmployeeTO(this);
		}

	}

}
