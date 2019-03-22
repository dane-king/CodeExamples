package collections.hash;

import java.util.HashMap;
import java.util.Map;

import collections.hashedObjects.WithHash;

public class HashingPractice {
	private final Map<WithHash, String> objectkeys = new HashMap<WithHash, String>();

	public static void main(final String[] args) {
		HashingPractice practice = new HashingPractice();
		practice.loadMap();

	}

	private void loadMap() {
		objectkeys.clear();
		objectkeys.put(new WithHash("Name1", 1), "value1");
		objectkeys.put(new WithHash("Name2", 1), "value2");
		objectkeys.put(new WithHash("Name2", 2), "value22");
		objectkeys.put(new WithHash("Name3", 3), "value3");
		String valueString = objectkeys.get(new WithHash("Name2", 2));
		System.out.println("ValueString>>>>>" + valueString);
	}
}
