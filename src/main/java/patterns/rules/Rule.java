package patterns.rules;

public interface Rule<K, V> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see patterns.rules.Rule#evaluate(patterns.rules.Fact)
	 */
	public abstract boolean evaluate(K key, V value);

	public boolean getTrue(K key, V value);

	public boolean getFalse(K key, V value);

}