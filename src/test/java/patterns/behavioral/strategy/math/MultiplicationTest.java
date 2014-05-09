package patterns.behavioral.strategy.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultiplicationTest {
	@Test
	public void shouldAddTwoNumbers() {
		assertEquals(6, new Multiplication().execute(2, 3));
	}
}
