package testing.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

public class PojoTheSame extends TypeSafeMatcher<Pojo> {

	private final Pojo pojo;

	public PojoTheSame(final Pojo pojoParam) {
		this.pojo = pojoParam;
	}

	public void describeTo(final Description description) {
		description.appendText("Pojos are not the same - sad face");

	}

	@Override
	public boolean matchesSafely(final Pojo pojo2) {
		return pojo.getFname().equals(pojo2.getFname()) && pojo.getLname().equals(pojo2.getLname());
	}

	@Factory
	public static <T> Matcher<Pojo> theSame(final Pojo pojo) {
		return new PojoTheSame(pojo);
	}
}
