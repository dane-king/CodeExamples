package enums;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testAlabama(){
		State alabama=State.find(1);
		assertEquals(State.AL,alabama);
		assertEquals("Alabama",alabama.getLabel());
		assertEquals("AL",alabama.name());
		assertEquals("AL",alabama.getAbbreviation());
	}
	
	
	@Test
	public void testOhio(){
		State ohio=State.find(35);
		assertEquals(State.OH,ohio);
		assertEquals("Ohio",ohio.getLabel());
		assertEquals("OH",ohio.name());
		assertEquals("OH",ohio.getAbbreviation());
	}
	
	

}
