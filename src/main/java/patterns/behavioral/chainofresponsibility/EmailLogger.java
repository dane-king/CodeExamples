package patterns.behavioral.chainofresponsibility;

public class EmailLogger extends Logger {

	private static final String LOGGING_TYPE = "email";

	@Override
	public String writeMessage(String msg) {
		return String.format(BASE_MSG, LOGGING_TYPE,msg);
	}

	public EmailLogger(Status mask) {
		this.setMask(mask);
	}
	

}
