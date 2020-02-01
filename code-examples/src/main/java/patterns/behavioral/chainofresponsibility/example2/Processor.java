package patterns.behavioral.chainofresponsibility.example2;

public abstract class Processor {
	protected Processor next;

	public enum State {
		CREATED, PROCESSING, DONE;
	};

	protected State state;

	public void handle(final Event event) {

	}

	protected void process(final Event event) {
		// TODO Auto-generated method stub

	}
}