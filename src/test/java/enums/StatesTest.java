package enums;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StatesTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testAlabama(){
		States alabama=States.AL;
		assertEquals("Alabama",alabama.getLabel());
		assertEquals("AL",alabama.name());
		assertEquals("AL",alabama.getAbbreviation());
	}
	
	
	@Test
	public void testOhio(){
		States ohio=States.OH;
		assertEquals("Ohio",ohio.getLabel());
		assertEquals("OH",ohio.name());
		assertEquals("OH",ohio.getAbbreviation());
	}
	
}
