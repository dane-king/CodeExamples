package patterns.creational;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.drools.core.util.StringUtils;
import org.junit.Test;

import patterns.creational.builder.OptionalRequired;

public class BuilderTest {

	@Test
	public void testCreationOnlyRequired() {
		OptionalRequired build=new OptionalRequired.InternalBuilder("required1", "required2").build();
		assertEquals("required1",build.getRequired1());
		assertEquals("required2",build.getRequired2());
		
	}
	@Test
	public void testCreationOnlyRequiredOneOptional() {
		OptionalRequired build=new OptionalRequired.InternalBuilder("required1", "required2").option1("option1").build();
		assertFalse(StringUtils.isEmpty(build.getRequired1()));
		assertFalse(StringUtils.isEmpty(build.getRequired2()));
		assertEquals("option1",build.getOptional1());
		
	}
	@Test
	public void testCreationOnlyRequiredThreeOptional() {
		OptionalRequired build=new OptionalRequired.InternalBuilder("required1", "required2").option1("option1").option2("option2").option3("option3").build();
		assertFalse(StringUtils.isEmpty(build.getRequired1()));
		assertFalse(StringUtils.isEmpty(build.getRequired2()));
		assertEquals("option1",build.getOptional1());
		assertEquals("option2",build.getOptional2());
		assertEquals("option3",build.getOptional3());
		
	}
}
