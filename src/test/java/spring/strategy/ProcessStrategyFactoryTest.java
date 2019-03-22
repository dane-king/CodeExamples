package spring.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import spring.config.AppConfig;

//Need Runswith to autowire
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class ProcessStrategyFactoryTest {

	@Autowired
	private ProcessStrategyFactory processStrategyFactory;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testT1ShouldReturnType1doc() {
		String actual = processStrategyFactory.getProcessor("t1").process("doc");
		assertEquals("Type1doc", actual);
	}

	@Test
	public void testT2ShouldReturnType2doc() {
		String actual = processStrategyFactory.getProcessor("Type2").process("doc");
		assertEquals("Type2doc", actual);
	}

	@Test
	public void testT3ShouldReturnType3doc() {
		String actual = processStrategyFactory.getProcessor("Type3").process("doc");
		assertEquals("Type3doc", actual);
	}

}
