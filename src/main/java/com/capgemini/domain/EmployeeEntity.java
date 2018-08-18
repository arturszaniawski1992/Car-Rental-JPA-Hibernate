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

import exception.InvalidCreationException;

@Entity
@Table(name = "employee")
public class EmployeeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50, nullable = false)
	private String firstName;
	@Column(length = 50, nullable = false)
	private String lastName;
	@Column
	private Double salary;
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	@Column(length = 50)
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

	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(EmployeeEntityBuilder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.salary = builder.salary;
		this.dateOfBirth = builder.dateOfBirth;
		this.mobile = builder.mobile;
		this.departmentEntity = builder.departmentEntity;
		this.positionEntity = builder.positionEntity;
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

	public DepartmentEntity getDepartmentEntity() {
		return departmentEntity;
	}

	public void setDepartmentEntity(DepartmentEntity departmentEntity) {
		this.departmentEntity = departmentEntity;
	}

	public PositionEntity getPositionEntity() {
		return positionEntity;
	}

	public void setPositionEntity(PositionEntity positionEntity) {
		this.positionEntity = positionEntity;
	}

	public List<CarEntity> getAttendCars() {
		return attendCars;
	}

	public void setAttendCars(List<CarEntity> attendCars) {
		this.attendCars = attendCars;
	}

	public static class EmployeeEntityBuilder {
		private Long id;
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

		public EmployeeEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public EmployeeEntityBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public EmployeeEntityBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public EmployeeEntityBuilder withSalary(Double salary) {
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
			if (firstName == null || lastName == null) {
				throw new InvalidCreationException("Incorrect employee to be created");
			}

			return new EmployeeEntity(this);
		}

	}
}