package patterns.behavioral.strategy.math.operations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DivisionTest {
	@Test
	public void shouldDivideTwoNumbers() {
		assertEquals(2, new Division().execute(6, 3));
	}

	@Test(expected = ArithmeticException.class)
	public void shouldThrowExceptionIfDivideByZero() {
		assertEquals(0, new Division().execute(6, 0));
	}
}
