package patterns.behavioral.strategy.math.operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplicationTest {
	@Test
	public void shouldAddTwoNumbers() {
		assertEquals(6, new Multiplication().execute(2, 3));
	}
}
