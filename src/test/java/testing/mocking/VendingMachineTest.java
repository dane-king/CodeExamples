package testing.mocking;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class VendingMachineTest {
	@Mock
	private Display display;

	@InjectMocks
	private VendingMachine machine;

	@Mock
	private CoinHandler coinHandler;

	private String coin;

	private BigDecimal amount;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		coin = "";
	}

	@Test
	public void shouldCallCoinHandlerWhenCoinIsInserted() throws Exception {
		machine.insert(coin);
		verify(coinHandler).accept(argThat(any(String.class)));
	}

	@Test
	public void shouldUpdateDisplayWhenCoinsAreAccepted() throws Exception {
		setupCoinHandlerAccept(true);
		machine.insert(coin);
		verify(display).update(argThat(any(String.class)));
	}

	@Test
	public void shouldNotUpdateDisplayWhenCoinsAreNotAccepted() throws Exception {
		setupCoinHandlerAccept(false);
		machine.insert(coin);
		verify(display, times(0)).update(argThat(any(String.class)));
	}

	@Test
	public void shouldDipenseIfEnoughCoinsAreDeposited() {
		Product product = machine.dispense(amount);
		assertNotNull(product);
	}

	private void setupCoinHandlerAccept(final Boolean returnValue) {
		when(coinHandler.accept(argThat(any(String.class)))).thenReturn(returnValue);
	}
}
