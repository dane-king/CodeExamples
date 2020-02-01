package patterns.behavioral.state;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class ContextTest {
	@Mock
	private State state;
	private Context context;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		context = new Context();
		context.setState(state);
	}

	@Test
	public void shouldInstantiateContext() {
		assertThat(context, notNullValue());
	}

	@Test
	public void shouldDelegateToStateWhenWriteNameIsCalled() {
		doNothing().when(state).toggle(isA(Context.class), anyString());
		context.toggle("StubName");
		verify(state).toggle(isA(Context.class), anyString());
	}

}
