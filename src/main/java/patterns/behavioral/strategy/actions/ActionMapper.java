package patterns.behavioral.strategy.actions;

public class ActionMapper {
	private final Dispatcher dispatcher;

	public ActionMapper(final Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	public Response dispatch(final String url, final String... params) {
		return dispatcher.dispatch(url, params);
	}
}
