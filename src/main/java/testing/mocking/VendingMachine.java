package testing.mocking;

import java.math.BigDecimal;

public class VendingMachine {
	private Display display;
	private CoinHandler handler;

	public void insert(final String coin) {
		if (handler.accept(coin)) {
			display.update(coin);
		}
	}

	public Product dispense(final BigDecimal amount) {
		return new Product();
	}

}
