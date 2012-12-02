package patterns.behavioral.chainofresponsibility.example1;

import org.drools.core.util.StringUtils;


public  abstract class Logger{
	//inner class could be separate class, used inner for simplicity of example
	public enum Status{
		ERR(3),NOTICE(5),DEBUG(7);
		private Integer priority;

		Status(Integer priority){
			this.priority=priority;
		}

		public Integer getPriority() {
			return priority;
		}
		public Boolean shouldHandle(Status currentStatus){
			//if current status is less than what handles than return true
			return currentStatus.getPriority().compareTo(this.getPriority())<=0;
		}
	}
	//end of enum

	protected static final String BASE_MSG = "Sending to %1s %2s";
	
	//Each logger subclass declares error message level it handles
	private Logger next;
	private Status handle;

	public void setMask(Status handles) {
		this.handle = handles;
	}

	public Logger setNext(Logger next){
		this.next=next;
		return next;
	}
	
	public String message(String msg, Status currentStatus){
		String returnMsg="";
		if(handle.shouldHandle(currentStatus)){
			returnMsg += writeMessage(msg);
		}
		if(next !=null){
			String nextMsg=next.message(msg,currentStatus);
			if(!StringUtils.isEmpty(nextMsg)){
				returnMsg+=":" + nextMsg;
			}
		}
		return returnMsg;
	}

	public abstract String writeMessage(String msg);


}
