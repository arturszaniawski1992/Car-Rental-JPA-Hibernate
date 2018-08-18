package com.capgemini.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import exception.InvalidCreationException;

@Entity
@Table(name = "position")
public class PositionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "position", nullable = false)
	private String position;

	@OneToMany(mappedBy = "positionEntity")
	private List<EmployeeEntity> employees;

	public PositionEntity() {
		super();
	}

	public PositionEntity(PositionEntityBuilder builder) {
		this.id = builder.id;
		this.position = builder.position;
		this.employees = builder.employees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	public static PositionEntityBuilder builder() {
		return new PositionEntityBuilder();
	}

	public static class PositionEntityBuilder {

		private Long id;
		private String position;
		private List<EmployeeEntity> employees;

		public PositionEntityBuilder() {
			super();
		}

		public PositionEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public PositionEntityBuilder withPosition(String position) {
			this.position = position;
			return this;
		}

		public PositionEntityBuilder withEmployees(List<EmployeeEntity> employees) {
			this.employees = employees;
			return this;
		}

		public PositionEntity build() {
			if (position == null) {
				throw new InvalidCreationException("Incorrect position to be created");
			}

			return new PositionEntity(this);
		}

	}
}
