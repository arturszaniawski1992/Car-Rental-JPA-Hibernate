package embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import exception.IncorrectAdressCreated;

@Embeddable
public class AdressData {

	@Column(name = "street", length = 40, nullable = false)
	private String street;
	@Column(name = "number", length = 30, nullable = false)
	private int number;
	@Column(name = "city", length = 30, nullable = false)
	private String city;
	@Column(name = "post_code", length = 6, nullable = false)
	private String postCode;

	public AdressData() {
		super();
	}

	public AdressData(AdressDataBuilder builder) {
		this.street = builder.street;
		this.number = builder.number;
		this.city = builder.city;
		this.postCode = builder.postCode;

	}

	public String getStreet() {
		return street;
	}

	public int getNumber() {
		return number;
	}

	public String getCity() {
		return city;
	}

	public String getPostCode() {
		return postCode;
	}

	public static class AdressDataBuilder {

		private String street;
		private int number;
		private String city;
		private String postCode;

		public AdressDataBuilder() {
			super();
		}

		public AdressDataBuilder withStreet(String street) {
			this.street = street;
			return this;
		}

		public AdressDataBuilder withNumber(int number) {
			this.number = number;
			return this;

		}

		public AdressDataBuilder withCity(String city) {
			this.city = city;
			return this;

		}

		public AdressDataBuilder withPostCode(String postCode) {
			this.postCode = postCode;
			return this;

		}

		public AdressData build() throws IncorrectAdressCreated {
			if (street != null || city != null) {
				throw new IncorrectAdressCreated();

			}
			return new AdressData(this);
		}
	}

}
