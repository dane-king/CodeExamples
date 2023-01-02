package patterns.rules;

import org.junit.Test;

import static org.junit.Assert.*;

public class RuleTest {

	// Rules to for testing
	private final Rule<Integer> lessThan10 = new LessThan10Rule(10);
	private final Rule<Integer> greaterThan5Andlessthan10 = new GreaterThan5Rule(5).AND(new LessThan10Rule(10));
	private final Rule<Integer> lessthan10OrlessThan20 = new LessThan10Rule(10).OR(new LessThan20Rule(20));

	private final Rule<String> isApplicableState = new IsApplicableState("OH");

	@Test
	public void instantiate_rule_should_not_be_null() {
		assertNotNull(lessThan10);
	}

	@Test
	public void rule_should_accept_a_key_value() {
		lessThan10.evaluate(0);
	}

	@Test
	public void rule_evaluate_a_true_fact_to_true() {
		assertTrue(lessThan10.evaluate(9));
	}

	@Test
	public void rule_evaluate_a_fact_OR_another_fact_to_true() {
		assertTrue(lessthan10OrlessThan20.evaluate(17));
	}

	@Test
	public void rule_evaluate_a_fact_OR_another_fact_to_false() {
		assertFalse(lessthan10OrlessThan20.evaluate(23));
	}

	@Test
	public void rule_evaluate_a_fact_AND_another_fact_to_true() {
		assertTrue(greaterThan5Andlessthan10.evaluate(7));
	}

	@Test
	public void rule_evaluate_a_true_OR_fact_to_false() {
		assertFalse(greaterThan5Andlessthan10.evaluate(11));
	}

	@Test
	public void rule_evaluate_a_false_fact_to_false() {
		assertFalse(lessThan10.evaluate(11));
	}

	@Test
	public void rule_evaluate_a_false_string_fact_to_false() {
		assertFalse(isApplicableState.evaluate("IN"));
	}

	@Test
	public void rule_evaluate_a_true_string_fact_to_true() {
		assertTrue(isApplicableState.evaluate("OH"));
	}
}
