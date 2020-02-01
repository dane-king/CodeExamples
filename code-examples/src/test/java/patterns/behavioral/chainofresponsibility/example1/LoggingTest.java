package patterns.behavioral.chainofresponsibility.example1;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import patterns.behavioral.chainofresponsibility.example1.Logger.Status;

public class LoggingTest {

	@SuppressWarnings("unused")
	private static Logger stdoutLogger, emailLogger, stdErrLogger;

	@BeforeClass
	public static void setUp() {
		stdoutLogger = new StdoutLogger(Status.DEBUG);
		emailLogger = stdoutLogger.setNext(new EmailLogger(Status.NOTICE));
		stdErrLogger = emailLogger.setNext(new StdErrLogger(Status.ERR));
	}

	@Test
	public void testStdOut() {

		String actualMsg = stdoutLogger.message("Entering function y",
				Status.DEBUG);
		assertEquals("Sending to stdout Entering function y", actualMsg);

	}

	@Test
	public void testStdOutAndEmail() {

		String actualMsg = stdoutLogger.message("Step1 Completed",
				Status.NOTICE);
		assertEquals(
				"Sending to stdout Step1 Completed:Sending to email Step1 Completed",
				actualMsg);

	}

	@Test
	public void testStdOutEmailAndStdErr() {

		String actualMsg = stdoutLogger.message("An error has occurred",
				Status.ERR);
		assertEquals(
				"Sending to stdout An error has occurred:Sending to email An error has occurred:Sending to stderr An error has occurred",
				actualMsg);

	}

}
