package patterns.behavioral.strategy.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SubtractionTest {
	@Test
	public void shouldSubtractTwoNumbers() {
		assertEquals(1, new Subtraction().execute(5, 4));
	}

}
