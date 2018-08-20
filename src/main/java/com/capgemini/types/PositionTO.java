package com.capgemini.types;

import exception.InvalidCreationException;

public class PositionTO {
	private Long id;
	private String position;

	public PositionTO() {
	}

	public PositionTO(PositionTOBuilder builder) {
		this.id = builder.id;
		this.position = builder.position;

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

	public static PositionTOBuilder builder() {
		return new PositionTOBuilder();
	}

	public static class PositionTOBuilder {
		private String position;
		private Long id;

		/**
		 * Default constructor for position TO builder.
		 *
		 */
		public PositionTOBuilder() {
			super();
		}

		/**
		 * This is the method which add id to position.
		 * 
		 * @param Long
		 *            as id for position.
		 * @return Id of position.
		 */
		public PositionTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		/**
		 * This is the method which add employees to position.
		 * 
		 * @param List
		 *            as employees for position.
		 * @return position for position.
		 */
		public PositionTOBuilder withPosition(String position) {
			this.position = position;
			return this;
		}

		/**
		 * This is the method which build position TO and if there is no
		 * demanded params throw exception.
		 * 
		 * @param Obligatory
		 *            String position.
		 * @return Position TO.
		 */
		public PositionTO build() {
			if (position == null) {
				throw new InvalidCreationException("Incorrect position to be created");
			}
			return new PositionTO(this);
		}

	}
}
