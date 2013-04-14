package patterns.rules;

public abstract class AbstractRule<K, V> implements Rule<K, V> {
	public AbstractRule() {
	}

	public AbstractRule(final Rule<K, V> trueRule, final Rule<K, V> falseRule) {
		this.trueRule = trueRule;
		this.falseRule = falseRule;
	}

	public abstract boolean evaluate(K key, V value);

	public void assertValid(final String key) {
		if (key == null) {
			throw new IllegalArgumentException("key cannot be null");
		}
	}

	private Rule<K, V> trueRule;
	private Rule<K, V> falseRule;

	public void setTrue(final Rule<K, V> trueRule) {
		this.trueRule = trueRule;
	}

	public boolean getTrue(final K key, final V value) {
		if (trueRule == null) {
			return true;
		} else {
			return trueRule.evaluate(key, value);
		}

	}

	public void setFalse(final Rule<K, V> falseRule) {
		this.falseRule = falseRule;
	}

	public boolean getFalse(final K key, final V value) {
		if (falseRule == null) {
			return false;
		} else {
			return falseRule.evaluate(key, value);
		}
	}

	public Rule<K, V> OR(final Rule<K, V> rule) {
		this.trueRule = null;
		this.falseRule = rule;
		return this;
	}

	public Rule<K, V> AND(final Rule<K, V> rule) {
		this.trueRule = rule;
		this.falseRule = null;
		return this;
	}
}
