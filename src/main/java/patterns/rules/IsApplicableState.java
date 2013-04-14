package patterns.rules;

import java.util.List;

public class IsApplicableState extends AbstractRule<String, List<String>> {

	@Override
	public boolean evaluate(final String key, final List<String> value) {
		assertValid(key);
		return (value.contains(key) ? getTrue(key, value) : getFalse(key, value));
	}
}
