package patterns.behavioral.chainofresponsibility;

public class StdErrLogger extends Logger {

	private static final String LOGGING_TYPE = "stderr";

	@Override
	public String writeMessage(String msg) {
		return String.format(BASE_MSG, LOGGING_TYPE,msg);
	}

	public StdErrLogger(Status mask) {
		this.setMask(mask);
	}
	

}
