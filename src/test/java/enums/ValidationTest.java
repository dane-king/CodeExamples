package enums;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidationTest {

	@Test
	public void testEmailValidate() {
		Validation email=Validation.Email;
		//valid
		assertTrue(email.validate("test@test.com"));
		assertTrue(email.validate("test.test@test.com"));
		
		//invalid
		assertFalse(email.validate("$test@test.com"));
		assertFalse(email.validate("test@$test.com"));
		assertFalse(email.validate("test@test.$com"));
		assertFalse(email.validate("test@test.c"));
	}
	@Test
	public void testNameValidate() {
		Validation name=Validation.Name;
		//valid
		assertTrue(name.validate("Smith"));
		assertTrue(name.validate("O'Brien"));
		assertTrue(name.validate("Smith-Jones"));
		assertTrue(name.validate("Jone-Smith-Hayes"));
		
		//invalid
		assertFalse(name.validate("Smith1"));
		assertFalse(name.validate("Sm1th"));
		assertFalse(name.validate("Jone$Test"));
	}
}
