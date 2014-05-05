package patterns.behavioral.state;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OnStateTest {
	@Mock
	private Context context;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void shouldCallSetStateOnContextWhenToggleIsCalled() {
		OnState onState = new OnState();
		doNothing().when(context).toggle(isA(String.class));
		String name = "";
		onState.toggle(context, name);
		verify(context).setState(isA(State.class));

	}
}
