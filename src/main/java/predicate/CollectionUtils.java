package predicate;

import java.util.Iterator;

public class CollectionUtils {
	public static <T> void filter(Iterator<T> target, Predicate<T> predicate) {
		while (target.hasNext()) {
			T element = target.next();
			if (!predicate.apply(element)) {
				target.remove();
			}
		}
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
