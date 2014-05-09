package patterns.behavioral.strategy.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdditionTest {
	@Test
	public void shouldAddTwoNumbers() {
		assertEquals(3, new Addition().execute(2, 1));
	}
}
