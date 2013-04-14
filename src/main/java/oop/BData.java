package oop;

import java.io.Serializable;

public class BData implements Serializable {
	private static final long serialVersionUID = 3109243553511713574L;

	private final String name;
	private final Integer number;

	public Integer getNumber() {
		return this.number;
	}

	public String getName() {
		return this.name;
	}

	public BData(final String name, final Integer number) {
		super();
		this.name = name;
		this.number = number;
	}
}