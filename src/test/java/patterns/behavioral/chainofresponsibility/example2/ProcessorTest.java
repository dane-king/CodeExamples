package patterns.behavioral.chainofresponsibility.example2;

import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.assertNotNull;

public class ProcessorTest {

	private Processor processor;

	@Before
	public void setup() {
		// processor = new Processor();
	}

	@Ignore
	public void instance_of_processor_should_not_be_null() throws Exception {
		assertNotNull(processor);
	}

	@Ignore
	public void handle_should_accept_event() throws Exception {
		Event event = new Event();
		processor.handle(event);
	}
}
