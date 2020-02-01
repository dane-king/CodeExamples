package patterns.behavioral.command.factory;

import java.util.Map;
import java.util.Map.Entry;

public class AutoRouter implements Router {

	public static final String KEY = "auto";

	public boolean handle(Map<String, String> params) {
		System.out.println("Processing AutoRouter");
		for (Entry<String,String> param : params.entrySet()) {
			System.out.println(String.format("Key is %1s and Value is %2s", param.getKey(),param.getValue()));
		}
		return true;
	}

}
