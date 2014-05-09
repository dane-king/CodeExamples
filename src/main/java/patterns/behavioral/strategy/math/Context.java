package patterns.behavioral.strategy.math;

import patterns.behavioral.strategy.math.operations.Strategy;

class Context {
	private final Strategy strategy;

	public Context(final Strategy stratagy) {
		this.strategy = stratagy;
	}

	public int execute(final int x, final int y) {
		return strategy.execute(x, y);

	}

}
