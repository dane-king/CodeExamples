package predicate;

import org.apache.commons.lang3.StringUtils;

import domain.common.User;

public class MatchPredicate<T> implements Predicate<T> {
	private T matchObject;
	
	public MatchPredicate(T matchObject) {
		this.matchObject = matchObject;
	}

	public boolean apply(T type) {
		return type.equals(matchObject);
	}



}
