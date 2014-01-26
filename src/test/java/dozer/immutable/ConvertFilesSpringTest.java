package dozer.immutable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:**/dozerSpringContext.xml")
public class ConvertFilesSpringTest {
	@Autowired
	private TestSpringCustomConverter converter;

	@Test
	public void convertSourceToTargetUsingConverter() throws Exception {
		Source source = stubSource();
		ImmutableDestination destination = converter.convertTo(source);
		assertEquals("one", destination.getOne());
		assertEquals("two", destination.getTwo());
	}

	private Source stubSource() {
		Source source = new Source();
		source.setOne("one");
		source.setTwo("two");
		return source;
	}

}
