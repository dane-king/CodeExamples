package patterns.behavioral.strategy.dispatch.controllers;

public interface Dispatcher {
	Response dispatch(final String url, final String... params);
}
