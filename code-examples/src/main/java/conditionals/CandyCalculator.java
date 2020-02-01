package conditionals;

public class CandyCalculator {
	public double calculate(final String type, final int quantity) {
		Candy candy = getCandy(type);
		return candy.getCost() * quantity;
	}

	private Candy getCandy(final String type) {
		CandyFactory factory = new CandyFactory();
		return factory.getInstance(type);
	}

}
