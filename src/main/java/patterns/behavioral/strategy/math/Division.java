package patterns.behavioral.strategy.math;

import patterns.behavioral.strategy.Strategy;

public class Division implements Strategy {

	public int execute(final int x, final int y) {
		return x / y;
	}

}
