package enums.color;

public enum Color {
	RED("Red", 111);
	private final String name;
	private final int hexCode;

	Color(final String name, final int hexCode) {
		this.name = name;
		this.hexCode = hexCode;
	}

	public String getName() {
		return name;
	}

	public int getHexCode() {
		return hexCode;
	}

}
