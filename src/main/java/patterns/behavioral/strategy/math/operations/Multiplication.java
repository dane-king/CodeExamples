package patterns.behavioral.strategy.math.operations;

public class Multiplication implements Strategy {

	public int execute(final int x, final int y) {
		return x * y;
	}

}
