package com.capgemini.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.listeners.InsertListener;
import com.capgemini.listeners.UpdateListener;

import exception.InvalidCreationException;

@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({ UpdateListener.class, InsertListener.class })
public class EmployeeEntity extends AbstractEntity implements Serializable {

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

	/**
	 * Default constructor for employee contract entity.
	 *
	 */
	public EmployeeEntity() {
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

		/**
		 * Default constructor for employee employee entity builder.
		 *
		 */
		public EmployeeEntityBuilder() {
		}

		/**
		 * This is the method which add id to employee.
		 * 
		 * @param Long
		 *            as id for employee.
		 * @return Id of employee.
		 */
		public EmployeeEntityBuilder withId(Long id) {
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
		public EmployeeEntityBuilder withFirstName(String firstName) {
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
		public EmployeeEntityBuilder withLastName(String lastName) {
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
		public EmployeeEntityBuilder withSalary(Double salary) {
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
		public EmployeeEntityBuilder withDateOfBirth(LocalDate dateOfBirth) {
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
		public EmployeeEntityBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		/**
		 * This is the method which add department to employee.
		 * 
		 * @param DepartmentEntity
		 *            as department of employee.
		 * @return department of employee.
		 */
		public EmployeeEntityBuilder withDepartmentEntity(DepartmentEntity departmentEntity) {
			this.departmentEntity = departmentEntity;
			return this;
		}

		/**
		 * This is the method which add position to employee.
		 * 
		 * @param PositionEntity
		 *            as position of employee.
		 * @return position of employee.
		 */
		public EmployeeEntityBuilder withPositionEntity(PositionEntity positionEntity) {
			this.positionEntity = positionEntity;
			return this;
		}

		/**
		 * This is the method which add attend cars to employee.
		 * 
		 * @param List
		 *            as attend cars of employee.
		 * @return attend cars of employee.
		 */
		public EmployeeEntityBuilder withAttendCars(List<CarEntity> attendCars) {
			this.attendCars = attendCars;
			return this;
		}

		/**
		 * This is the method which build employee entity and if there is no
		 * demanded params throw exception.
		 * 
		 * @param Obligatory
		 *            String firstname, String lastname, String mobile,.
		 * @return Employee entity.
		 */
		public EmployeeEntity build() {
			if (firstName == null || lastName == null) {
				throw new InvalidCreationException("Incorrect employee to be created");
			}

			return new EmployeeEntity(this);
		}

	}
}