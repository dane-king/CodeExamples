package patterns.rules;

public interface Rule<T> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see patterns.rules.Rule#evaluate(patterns.rules.Fact)
	 */
	public abstract boolean evaluate(T value);

	public boolean getTrue(T value);

	public boolean getFalse(T value);

	public T getExpectedValue();

}