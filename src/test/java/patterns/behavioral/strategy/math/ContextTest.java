package patterns.behavioral.strategy.math;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import patterns.behavioral.strategy.math.operations.Strategy;

public class ContextTest {
	@Mock
	private Strategy strategy;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldCallStrategyExecuteWhenExecuteIsCalled() {
		Context context = new Context(strategy);
		context.execute(1, 2);
		verify(strategy).execute(1, 2);
	}
}
