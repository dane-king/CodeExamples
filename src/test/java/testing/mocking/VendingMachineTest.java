package testing.mocking;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

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
		verify(coinHandler).accept(anyString());
	}

	@Test
	public void shouldUpdateDisplayWhenCoinsAreAccepted() throws Exception {
		setupCoinHandlerAccept(true);
		machine.insert(coin);
		verify(display).update(anyString());
	}

	@Test
	public void shouldNotUpdateDisplayWhenCoinsAreNotAccepted() throws Exception {
		setupCoinHandlerAccept(false);
		machine.insert(coin);
		verify(display, times(0)).update(anyString());
	}

	@Test
	public void shouldDipenseIfEnoughCoinsAreDeposited() {
		Product product = machine.dispense(amount);
		assertNotNull(product);
	}

	private void setupCoinHandlerAccept(final Boolean returnValue) {
		when(coinHandler.accept(anyString())).thenReturn(returnValue);
	}
}
