package patterns.behavioral.command.factory;

import java.util.Map;
/**
 * 
 * @author Dane King
 * 
 *
 */
public interface Router {
	/**
	 * Add public key to use for looking up the Router in the CommandFactory
	 */
	
	/**
	 * Each Router implements their own specific logic handling the parameters
	 * and returning a status
	 * @param params a map of parameters, could be changed to a request
	 * @return boolean status of the handle
	 */
	public abstract boolean handle(Map<String, String> params);

}