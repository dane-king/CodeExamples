package oop;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.Field;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BObjectTest {
	private BObject target;

	@Before
	public void setup() {
		target = new BObject();
	}

	@Test
	public void type() throws Exception {
		assertTrue(target instanceof BObject);
	}

	@Test
	public void instantiation() throws Exception {
		assertThat(target, notNullValue());
	}

	@Test
	public void getName_Accepts_String() throws Exception {
		// given
		// e.g. : given(mocked.called()).willReturn(1);
		// when
		String actual = target.getName();
		// then
		// e.g. : verify(mocked).called();
		String expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void setName_Accepts_String() throws Exception {
		// given
		String name = "test";
		// e.g. : given(mocked.called()).willReturn(1);
		// when
		target.setName(name);
		// then
		assertThat(target.getName(), is(equalTo(name)));
	}

	@Test
	public void getNumber_Accepts_Integer() throws Exception {
		// given
		// e.g. : given(mocked.called()).willReturn(1);
		// when
		Integer actual = target.getNumber();
		// then
		// e.g. : verify(mocked).called();
		Integer expected = null;
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void setNumber_Accepts_Integer() throws Exception {
		// given
		Integer number = null;
		// e.g. : given(mocked.called()).willReturn(1);
		// when
		target.setNumber(number);
		// then
		assertNull(target.getNumber());
	}

	@Test
	public void incrementNumber_Accepts_Integer() throws Exception {
		// given
		Integer byNumber = null;
		// e.g. : given(mocked.called()).willReturn(1);
		// when
		target.incrementNumber(byNumber);
		// then
	}

	@Test
	public void incrementNumber_Accepts_Null_Does_not_Increment() throws Exception {
		// given
		Integer byNumber = null;
		int expectValue = 5;
		target.setNumber(new Integer(expectValue));
		// e.g. : given(mocked.called()).willReturn(1);
		// when
		target.incrementNumber(byNumber);
		// then
		assertEquals(expectValue, target.getNumber().intValue());
	}

	@Test
	public void incrementNumber_Accepts_0_Does_not_Increment() throws Exception {
		// given
		Integer byNumber = 0;
		int expectValue = 5;
		target.setNumber(new Integer(expectValue));
		// e.g. : given(mocked.called()).willReturn(1);
		// when
		target.incrementNumber(byNumber);
		// then
		assertEquals(expectValue, target.getNumber().intValue());
	}

	@Test
	public void incrementNumber_Accepts_2_Increments_Number() throws Exception {
		// given
		Integer byNumber = 2;
		int numberValue = 5;
		int expectedValue = numberValue + byNumber;
		target.setNumber(new Integer(numberValue));
		// e.g. : given(mocked.called()).willReturn(1);
		// when
		target.incrementNumber(byNumber);
		// then
		assertEquals(expectedValue, target.getNumber().intValue());
	}

	@Test
	public void getData_Represents_BObjectState() throws Exception {
		Integer number = 5;
		String name = "name";
		// given
		target.setNumber(new Integer(number));
		target.setName(name);
		// e.g. : given(mocked.called()).willReturn(1);
		// when
		BData data = target.getData();
		// then
		assertEquals(name, data.getName());
		assertEquals(number, data.getNumber());
	}

	@Test
	public void getData_is_Serializable() throws Exception {
		BData data = target.getData();
		assertTrue(data instanceof Serializable);
	}

	@Test
	public void getData__can_still_be_modified_with_reflection() throws IllegalArgumentException,
			IllegalAccessException, SecurityException, NoSuchFieldException {
		BObject holder = new BObject();
		holder.setName("name");
		holder.setNumber(5);
		BData data = holder.getData();
		Field privateStringField = BData.class.getDeclaredField("name");

		privateStringField.setAccessible(true);
		String name = "test";
		privateStringField.set(data, name);
		assertEquals(name, data.getName());

	}
}
