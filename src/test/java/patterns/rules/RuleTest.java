package patterns.rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RuleTest {

	// Rules to for testing
	private final Rule<String, Integer> lessThan10 = new LessThan10Rule();
	private final Rule<String, Integer> greaterThan5Andlessthan10 = new GreaterThan5Rule().AND(new LessThan10Rule());
	private final Rule<String, Integer> lessthan10OrlessThan20 = new LessThan10Rule().OR(new LessThan20Rule());

	// private final Rule<String, Integer> lessThan10AndApplicableState = new
	// LessThan10Rule()
	// .AND(new IsApplicableState());

	@Test
	public void instantiate_rule_should_not_be_null() {
		assertNotNull(lessThan10);
	}

	@Test
	public void rule_should_accept_a_key_value() {
		lessThan10.evaluate("", 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void rule_should_throw_error_if_key_is_null() {
		lessThan10.evaluate(null, 1);
	}

	@Test
	public void rule_evaluate_a_true_fact_to_true() {
		assertTrue(lessThan10.evaluate("number", 9));
	}

	@Test
	public void rule_evaluate_a_fact_OR_another_fact_to_true() {
		assertTrue(lessthan10OrlessThan20.evaluate("number", 17));
	}

	@Test
	public void rule_evaluate_a_fact_OR_another_fact_to_false() {
		assertFalse(lessthan10OrlessThan20.evaluate("number", 23));
	}

	@Test
	public void rule_evaluate_a_fact_AND_another_fact_to_true() {
		assertTrue(greaterThan5Andlessthan10.evaluate("number", 7));
	}

	@Test
	public void rule_evaluate_a_true_OR_fact_to_false() {
		assertFalse(greaterThan5Andlessthan10.evaluate("number", 11));
	}

	@Test
	public void rule_evaluate_a_false_fact_to_false() {
		assertFalse(lessThan10.evaluate("number", 11));
	}

}
