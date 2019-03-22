package testing.matchers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static testing.matchers.PojoTheSame.theSame;

import org.junit.Test;

public class PojoTest {
	@Test
	public void MyPojosCreatedTheSameShouldBeEqual() {
		Pojo pojo1 = new Pojo("fname", "lname");
		Pojo pojo2 = new Pojo("fname", "lname");
		assertThat(pojo1, is(theSame(pojo2)));
	}

	@Test
	public void MyPojosCreatedDifferentyShouldBeNotEqual() {
		Pojo pojo1 = new Pojo("fname1", "lname1");
		Pojo pojo2 = new Pojo("fname", "lname");
		assertThat(pojo1, is(not(theSame(pojo2))));
	}
}
