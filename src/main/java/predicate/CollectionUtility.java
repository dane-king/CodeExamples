package predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class CollectionUtility {
	public static <T> void filter(final Iterator<T> target, final Predicate<T> predicate) {
		while (target.hasNext()) {
			T element = target.next();
			if (!predicate.apply(element)) {
				target.remove();
			}
		}
	}

	public static <T extends Comparable<T>> Collection<T> removeDuplicates(final Collection<T> target) {
		Collection<T> results = new TreeSet<T>(target);
		return results;
	}

	public static <T> Collection<T> filter(final Collection<T> target, final Predicate<T> predicate) {
		Collection<T> results = new ArrayList<T>();
		for (T element : target) {
			if (predicate.apply(element)) {
				results.add(element);
			}
		}
		return results;
	}

	public static <T> int count(final Iterator<T> target, final Predicate<T> predicate) {
		int count = 0;
		while (target.hasNext()) {
			T element = target.next();
			if (predicate.apply(element)) {
				count++;
			}
		}
		return count;
	}

	public static <T> T find(final Collection<T> collection, final Predicate<T> predicate) {
		for (T t : collection) {
			if (predicate.apply(t)) {
				return t;
			}
		}
		return null;
	}
}
