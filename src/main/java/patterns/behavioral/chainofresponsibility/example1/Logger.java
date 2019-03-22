package patterns.behavioral.chainofresponsibility.example1;

import org.apache.commons.lang3.StringUtils;

public abstract class Logger {
	// inner class could be separate class, used inner for simplicity of example
	public enum Status {
		ERR(3), NOTICE(5), DEBUG(7);
		private final Integer priority;

		Status(final Integer priority) {
			this.priority = priority;
		}

		public Integer getPriority() {
			return priority;
		}

		public Boolean shouldHandle(final Status currentStatus) {
			// if current status is less than what handles than return true
			return currentStatus.getPriority().compareTo(this.getPriority()) <= 0;
		}
	}

	// end of enum

	protected static final String BASE_MSG = "Sending to %1s %2s";

	// Each logger subclass declares error message level it handles
	private Logger next;
	private Status handle;

	public void setMask(final Status handles) {
		this.handle = handles;
	}

	public Logger setNext(final Logger next) {
		this.next = next;
		return next;
	}

	public String message(final String msg, final Status status) {
		String returnMsg = "";
		if (handle.shouldHandle(status)) {
			returnMsg += writeMessage(msg);
		}
		if (next != null) {
			String nextMsg = next.message(msg, status);
			if (!StringUtils.isEmpty(nextMsg)) {
				returnMsg += ":" + nextMsg;
			}
		}
		return returnMsg;
	}

	public abstract String writeMessage(final String msg);

}
