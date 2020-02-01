package conditionals;

import java.util.HashMap;
import java.util.Map;

public class CandyFactory {
	private static Map<String, Candy> typesMap;
	static {
		typesMap = new HashMap<String, Candy>();
		typesMap.put("CHOCOLATE", new Chocolate());
		typesMap.put("HARD", new Hard());
		typesMap.put("GUM", new Gum());
		typesMap.put("TAFFY", new Taffy());
	}

	public Candy getInstance(final String type) {
		Candy candy = typesMap.get(type);
		return candy;
	}

	private void checkSupportedOperation(final String type, final Class<? extends Candy> candyType) {
		if (candyType == null) {
			throw new UnsupportedOperationException("type " + type + " is not a valid Candy Type");
		}
	}
}
