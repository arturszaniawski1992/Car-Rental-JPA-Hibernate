package com.capgemini.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 50, nullable = false)
	private String firstName;
	@Column(length = 50, nullable = false)
	private String lastName;
	@Column(nullable = false)
	private double salary;
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	@Column(length = 50, nullable = false)
	private String mobile;

	@ManyToOne
	@JoinColumn(name = "id_department")
	private DepartmentEntity departmentEntity;
	@ManyToOne
	@JoinColumn(name = "id_position")
	private PositionEntity positionEntity;
	@ManyToMany
	@JoinTable(name = "attendant", joinColumns = { @JoinColumn(name = "id_employee") }, inverseJoinColumns = {
			@JoinColumn(name = "id_car") })
	private List<CarEntity> attendCars;

	// zamiast CarEnitty LOng
	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(EmployeeEntityBuilder builder) {
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

	public static class EmployeeEntityBuilder {

		private String firstName;
		private String lastName;
		private double salary;
		private LocalDate dateOfBirth;
		private String mobile;
		private DepartmentEntity departmentEntity;
		private PositionEntity positionEntity;
		private List<CarEntity> attendCars;

		public EmployeeEntityBuilder() {
			super();
		}

		public EmployeeEntityBuilder withSalary(double salary) {
			this.salary = salary;
			return this;
		}

		public EmployeeEntityBuilder withDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public EmployeeEntityBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		public EmployeeEntityBuilder withDepartmentEntity(DepartmentEntity departmentEntity) {
			this.departmentEntity = departmentEntity;
			return this;
		}

		public EmployeeEntityBuilder withPositionEntity(PositionEntity positionEntity) {
			this.positionEntity = positionEntity;
			return this;
		}

		public EmployeeEntityBuilder withAttendCars(List<CarEntity> attendCars) {
			this.attendCars = attendCars;
			return this;
		}

		public EmployeeEntity build() {
			if (firstName != null || lastName != null) {
				throw new RuntimeException("Incorrect employee to be created");
			}

			return new EmployeeEntity(this);
		}

	}
}