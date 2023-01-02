package patterns.behavioral.strategy.math.operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdditionTest {
	@Test
	public void shouldAddTwoNumbers() {
		assertEquals(3, new Addition().execute(2, 1));
	}
}
