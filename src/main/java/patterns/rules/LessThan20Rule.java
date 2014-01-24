package patterns.rules;

public class LessThan20Rule extends AbstractRule<Integer> {

	public LessThan20Rule(final Integer expectedValue) {
		super(expectedValue);
	}

	public boolean evaluate(final Integer value) {
		return (value < getExpectedValue()) ? getTrue(value) : getFalse(value);
	}

}
