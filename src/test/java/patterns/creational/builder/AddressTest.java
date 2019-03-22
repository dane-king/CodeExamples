package patterns.creational.builder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddressTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldBeAbleToCreateAddressWithBuildAndRequiredParameter() {
		Address address = new AddressBuilder("required").build();
		assertNotNull(address);
		assertEquals("required", address.getRequired());

	}

	@Test
	public void shouldBeAbleToCreateAddressWithBuilWithOptionalParameter() {
		Address address = new AddressBuilder("required").streetAddress1("PO Box 123").build();
		assertNotNull(address);
		assertEquals("PO Box 123", address.getAddress1());

	}

}
