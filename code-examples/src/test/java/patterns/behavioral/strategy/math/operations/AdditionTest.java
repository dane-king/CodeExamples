package patterns.behavioral.strategy.math.operations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import patterns.behavioral.strategy.math.operations.Addition;

public class AdditionTest {
	@Test
	public void shouldAddTwoNumbers() {
		assertEquals(3, new Addition().execute(2, 1));
	}
}
