package patterns.rules;

public class IsApplicableState extends AbstractRule<String> {

	public IsApplicableState(final String expectedValue) {
		super(expectedValue);
	}

	public boolean evaluate(final String value) {
		return (getExpectedValue().equals(value) ? getTrue(value) : getFalse(value));
	}

}
