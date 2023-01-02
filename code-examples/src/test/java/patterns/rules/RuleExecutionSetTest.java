package patterns.rules;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class RuleExecutionSetTest {
	private RuleExecutionSet ruleExecutionSet;

	@Before
	public void setup() {
		ruleExecutionSet = new RuleExecutionSet();
	}

	@Test
	public void rule_execution_be_able_to_be_created() {
		assertNotNull(ruleExecutionSet);
	}

}
