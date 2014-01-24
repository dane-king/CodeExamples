package patterns.rules;

public class LessThan10Rule extends AbstractRule<Integer> {
	public LessThan10Rule(final Integer expectedValue) {
		super(expectedValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see patterns.rules.Rule#evaluate(patterns.rules.Fact)
	 */

	public boolean evaluate(final Integer value) {
		return (value < getExpectedValue()) ? getTrue(value) : getFalse(value);
	}

}
