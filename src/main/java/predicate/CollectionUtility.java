package predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class CollectionUtility {
	public static <T> void filter(Iterator<T> target, Predicate<T> predicate) {
		while (target.hasNext()) {
			T element = target.next();
			if (!predicate.apply(element)) {
				target.remove();
			}
		}
	}

	public static <T extends Comparable<T>> Collection<T> removeDuplicates(Collection<T> target) {
		Collection<T> results = new TreeSet<T>(target);
		return results;
	}

	public static <T> Collection<T> filter(Collection<T> target, Predicate<T> predicate) {
		Collection<T> results = new ArrayList<T>();
		for (T element : target) {
			if (predicate.apply(element)) {
				results.add(element);
			}
		}
		return results;
	}

	public static <T> int count(Iterator<T> target, Predicate<T> predicate) {
		int count = 0;
		while (target.hasNext()) {
			T element = target.next();
			if (predicate.apply(element)) {
				count++;
			}
		}
		return count;
	}
}
