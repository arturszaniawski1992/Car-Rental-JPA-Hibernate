package com.capgemini.types;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.DepartmentEntity;
import com.capgemini.domain.PositionEntity;

public class EmployeeTO {

	private String firstName;
	private String lastName;
	private double salary;
	private LocalDate dateOfBirth;
	private String mobile;
	private DepartmentEntity departmentEntity;
	private PositionEntity positionEntity;
	private List<CarEntity> attendCars;

	EmployeeTO() {
		super();
	}

	public EmployeeTO(EmployeeTOBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.salary = builder.salary;
		this.dateOfBirth = builder.dateOfBirth;
		this.mobile = builder.mobile;
		this.departmentEntity = builder.departmentEntity;
		this.positionEntity = builder.positionEntity;
		this.attendCars = builder.attendCars;
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

	public DepartmentEntity getDepartmentEntity() {
		return departmentEntity;
	}

	public PositionEntity getPositionEntity() {
		return positionEntity;
	}

	public List<CarEntity> getAttendCars() {
		return attendCars;
	}

	public static class EmployeeTOBuilder {

		private String firstName;
		private String lastName;
		private double salary;
		private LocalDate dateOfBirth;
		private String mobile;
		private DepartmentEntity departmentEntity;
		private PositionEntity positionEntity;
		private List<CarEntity> attendCars;

		public EmployeeTOBuilder() {
			super();
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

		public EmployeeTOBuilder withDepartmentEntity(DepartmentEntity departmentEntity) {
			this.departmentEntity = departmentEntity;
			return this;
		}

		public EmployeeTOBuilder withPositionEntity(PositionEntity positionEntity) {
			this.positionEntity = positionEntity;
			return this;
		}

		public EmployeeTOBuilder withAttendCars(List<CarEntity> attendCars) {
			this.attendCars = attendCars;
			return this;
		}

		public EmployeeTO build() {
			if (firstName != null || lastName != null) {
				// dodac wlasny wyhjatek!

				throw new RuntimeException("Incorrect employee to be created");
			}

			return new EmployeeTO(this);
		}

	}

}
