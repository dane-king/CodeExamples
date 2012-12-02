package patterns.behavioral.chainofresponsibility.example1;

public class StdoutLogger extends Logger {

	private static final String LOGGING_TYPE = "stdout";

	@Override
	public String writeMessage(String msg) {
		return String.format(BASE_MSG, LOGGING_TYPE,msg);
	}

	public StdoutLogger(Status mask) {
		this.setMask(mask);
	}
	

}
