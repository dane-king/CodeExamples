package spring.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class StrategyTest {
	@Spy
	private Strategy strategy;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void whenInvokeIsCalledWithAnAProcessIsCalled() {
		String expected = "Type1a";
		testStrategy("a", new Type1(), expected);
	}

	@Test
	public void whenInvokeIsCalledWithABProcessIsCalled() {
		String expected = "Type2b";
		testStrategy("b", new Type2(), expected);
	}

	@Test
	public void whenInvokeIsCalledWithACProcessIsCalled() {
		String expected = "Type3c";
		testStrategy("c", new Type3(), expected);
	}

	private void testStrategy(final String typeArgument, final IProcessStrategy type, final String expected) {
		setupType(typeArgument, type, expected);
		strategy.invoke(typeArgument);
		assertEquals(expected, strategy.getState());

	}

	private void setupType(final String typeArgument, final IProcessStrategy type, final String expected) {
		strategy.setType(type);
	}

	@Test
	public void whenInvokeIsCalledWithANullProcessIsCalled() {
		strategy.invoke(null);
		assertNull(strategy.getState());
	}
}
