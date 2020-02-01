package patterns.behavioral.command.factory;

import java.util.Map;
import java.util.Map.Entry;

public class PropertyRouter implements Router {

	public static final String KEY="property";
	
	
	/* (non-Javadoc)
	 * @see patterns.behavioral.commandfactory.Router#handle(java.util.Map)
	 */
	public boolean handle(Map<String,String> params){
		System.out.println("Processing PropertyRouter");
		for (Entry<String,String> param : params.entrySet()) {
			System.out.println(String.format("Key is %1s and Value is %2s", param.getKey(),param.getValue()));
		}
		return true;
	}


}
