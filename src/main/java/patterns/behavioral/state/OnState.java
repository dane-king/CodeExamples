package patterns.behavioral.state;

public class OnState implements State {

	public void toggle(final Context context, String name) {
		name = "ON";
		context.setState(this);
	}
}
