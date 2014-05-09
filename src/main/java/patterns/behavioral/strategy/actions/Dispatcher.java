package patterns.behavioral.strategy.actions;



public interface Dispatcher {
	Response dispatch(String url, String...params);
}
