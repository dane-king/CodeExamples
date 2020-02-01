package oop;

public class BObject {
	private String name;
	private Integer number;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(final Integer number) {
		this.number = number;
	}

	// simulates some business logic
	public void incrementNumber(final Integer byNumber) {
		if (byNumber == null) {
			return;
		}
		this.number += byNumber;
	}

	protected BData getData() {
		return new BData(this.name, this.number);
	}

}
