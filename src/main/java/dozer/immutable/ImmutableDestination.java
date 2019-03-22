package dozer.immutable;

public class ImmutableDestination {
	private final String one;
	private final String two;

	public ImmutableDestination() {
		super();
		one = "";
		two = "";
	}

	public ImmutableDestination(final String one, final String two) {
		this.one = one;
		this.two = two;
	}

	public String getOne() {
		return one;
	}

	public String getTwo() {
		return two;
	}

}
