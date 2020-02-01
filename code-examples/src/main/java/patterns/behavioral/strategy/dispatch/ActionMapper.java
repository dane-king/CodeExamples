package patterns.behavioral.strategy.dispatch;

import patterns.behavioral.strategy.dispatch.controllers.Dispatcher;
import patterns.behavioral.strategy.dispatch.controllers.Response;

public class ActionMapper {
	private final Dispatcher dispatcher;

	public ActionMapper(final Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	public Response dispatch(final String url, final String... params) {
		return dispatcher.dispatch(url, params);
	}
}
