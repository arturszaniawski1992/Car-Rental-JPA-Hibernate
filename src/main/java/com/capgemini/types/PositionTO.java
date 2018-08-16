package com.capgemini.types;

public class PositionTO {
	private Long id;
	private String position;

	public PositionTO() {
	}

	public PositionTO(PositionTOBuilder builder) {
		this.position = builder.position;
	}

	public Long getId() {
		return id;
	}

	public String getPosition() {
		return position;
	}

	public static PositionTOBuilder builder() {
		return new PositionTOBuilder();
	}

	public static class PositionTOBuilder {
		private String position;

		public PositionTOBuilder() {
			super();
		}

		public PositionTOBuilder withPosition(String position) {
			this.position = position;
			return this;
		}

		public PositionTO build() {
			return new PositionTO(this);
		}

	}
}
