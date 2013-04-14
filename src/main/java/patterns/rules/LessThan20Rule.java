package patterns.rules;

public class LessThan20Rule extends AbstractRule<String, Integer> {

	@Override
	public boolean evaluate(final String key, final Integer value) {
		if (key == null) {
			throw new IllegalArgumentException("Fact object key was null");
		}
		return (value < 20) ? getTrue(key, value) : getFalse(key, value);
	}

}
