package patterns.behavioral.state;

/**
 * Context dispatches to State
 * 
 * @author kingd9
 * 
 */
class Context {
	private State state;

	public void toggle(final String name) {
		state.toggle(this, name);
	}

	public void setState(final State state) {
		this.state = state;
	}

}
