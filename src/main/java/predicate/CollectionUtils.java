package predicate;

import java.util.Iterator;

public class CollectionUtils {
	public static <T> void filter(final Iterator<T> target, final Predicate<T> predicate) {
		while (target.hasNext()) {
			T element = target.next();
			if (!predicate.apply(element)) {
				target.remove();
			}
		}
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
}
