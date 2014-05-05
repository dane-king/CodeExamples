package predicate;

public class MatchPredicate<T> implements Predicate<T> {
	private final T matchObject;

	public MatchPredicate(final T matchObject) {
		this.matchObject = matchObject;
	}

	public boolean apply(final T type) {
		return type.equals(matchObject);
	}

}
