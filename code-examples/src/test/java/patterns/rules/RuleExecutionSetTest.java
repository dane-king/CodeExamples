package patterns.rules;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

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
