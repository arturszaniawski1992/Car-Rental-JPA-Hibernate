package com.capgemini.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
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

import exception.InvalidCreationException;

@Entity
@Table(name = "position")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({ UpdateListener.class, InsertListener.class })
public class PositionEntity extends AbstractEntity implements Serializable {

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

	/**
	 * Default constructor for position entity.
	 *
	 */
	public PositionEntity() {
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

		/**
		 * Default constructor for position entity builder.
		 *
		 */
		public PositionEntityBuilder() {
		}

		/**
		 * This is the method which add id to position.
		 * 
		 * @param Long
		 *            as id for position.
		 * @return Id of position.
		 */
		public PositionEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		/**
		 * This is the method which add position to position.
		 * 
		 * @param String
		 *            as position for position.
		 * @return position for position.
		 */
		public PositionEntityBuilder withPosition(String position) {
			this.position = position;
			return this;
		}

		/**
		 * This is the method which add employees to position.
		 * 
		 * @param List
		 *            as employees for position.
		 * @return position for position.
		 */
		public PositionEntityBuilder withEmployees(List<EmployeeEntity> employees) {
			this.employees = employees;
			return this;
		}

		/**
		 * This is the method which build position entity and if there is no
		 * demanded params throw exception.
		 * 
		 * @param Obligatory
		 *            String position.
		 * @return Position entity.
		 */
		public PositionEntity build() {
			if (position == null) {
				throw new InvalidCreationException("Incorrect position to be created");
			}

			return new PositionEntity(this);
		}

	}
}
