package patterns.rules;

public abstract class AbstractRule<T> implements Rule<T> {

	public AbstractRule(final T expectedValue) {
		this.expectedValue = expectedValue;
	}

	public AbstractRule(final T expectedValue, final Rule<T> trueRule, final Rule<T> falseRule) {
		this.expectedValue = expectedValue;
		this.trueRule = trueRule;
		this.falseRule = falseRule;
	}

	private Rule<T> trueRule;
	private Rule<T> falseRule;
	private final T expectedValue;

	public T getExpectedValue() {
		return expectedValue;
	}

	public void setTrue(final Rule<T> trueRule) {
		this.trueRule = trueRule;
	}

	public boolean getTrue(final T value) {
		if (trueRule == null) {
			return true;
		} else {
			return trueRule.evaluate(value);
		}

	}

	public void setFalse(final Rule<T> falseRule) {
		this.falseRule = falseRule;
	}

	public boolean getFalse(final T value) {
		if (falseRule == null) {
			return false;
		} else {
			return falseRule.evaluate(value);
		}
	}

	public Rule<T> OR(final Rule<T> rule) {
		this.trueRule = null;
		this.falseRule = rule;
		return this;
	}

	public Rule<T> AND(final Rule<T> rule) {
		this.trueRule = rule;
		this.falseRule = null;
		return this;
	}
}
