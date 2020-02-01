package generics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PairTest {

	@Test
	public void testGetFirst() {
		Pair<String, Integer> pair = new Pair<String, Integer>(new String("x"),
				new Integer("5"));
		assertEquals("x", pair.getFirst());
	}

	@Test
	public void testGetFirstReverse() {
		Pair<Integer, String> pair = new Pair<Integer, String>(
				new Integer("5"), new String("x"));
		assertEquals(Integer.valueOf(5), pair.getFirst());
	}

	@Test
	public void testGetSecondReverse() {
		Pair<Integer, String> pair = new Pair<Integer, String>(
				new Integer("5"), new String("x"));
		assertEquals("x", pair.getSecond());
	}

	@Test
	public void testGetSecond() {
		Pair<String, Integer> pair = new Pair<String, Integer>(new String("x"),
				new Integer("5"));
		assertEquals(Integer.valueOf(5), pair.getSecond());
	}

	@Test
	public void testSetFirst() {
		Pair<String, Integer> pair = new Pair<String, Integer>(new String("x"),
				new Integer("5"));
		pair.setFirst("y");
		assertEquals("y", pair.getFirst());
	}

	@Test
	public void testSetSecond() {
		Pair<String, Integer> pair = new Pair<String, Integer>(new String("x"),
				new Integer("5"));
		pair.setSecond(new Integer("12"));

		assertEquals(Integer.valueOf(12), pair.getSecond());
	}

}
