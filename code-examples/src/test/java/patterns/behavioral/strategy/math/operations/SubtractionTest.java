package patterns.behavioral.strategy.math.operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubtractionTest {
	@Test
	public void shouldSubtractTwoNumbers() {
		assertEquals(1, new Subtraction().execute(5, 4));
	}

}
