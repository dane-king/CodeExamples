package patterns.rules;

public class GreaterThan5Rule extends AbstractRule<String, Integer> {
	/*
	 * (non-Javadoc)
	 * 
	 * @see patterns.rules.Rule#evaluate(patterns.rules.Fact)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see patterns.rules.Rule#evaluate(patterns.rules.Fact)
	 */
	@Override
	public boolean evaluate(final String key, final Integer value) {
		if (key == null) {
			throw new IllegalArgumentException("Fact object key was null");
		}
		return (value > 5) ? getTrue(key, value) : getFalse(key, value);
	}

}
