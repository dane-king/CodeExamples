package patterns.behavioral.strategy.dispatch;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import patterns.behavioral.strategy.dispatch.controllers.Dispatcher;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyVararg;
import static org.mockito.Mockito.verify;

public class ActionMapperTest {
	@Mock
	private Dispatcher dispatcher;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldCallDispatherDispatchWhenDispatchIsCalled() {

		ActionMapper mapper = new ActionMapper(dispatcher);
		mapper.dispatch("url", "1", "2");
		verify(dispatcher).dispatch(anyString(), (String[]) anyVararg());
	}
}
