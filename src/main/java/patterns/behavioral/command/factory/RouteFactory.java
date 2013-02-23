package patterns.behavioral.command.factory;

import java.util.HashMap;
import java.util.Map;

public class RouteFactory {
	private static Map<String, Router> routes=new HashMap<String, Router>();
	private static RouteFactory factory=new RouteFactory();
	private RouteFactory(){
		routes.put(PropertyRouter.KEY, new PropertyRouter());
		routes.put(AutoRouter.KEY, new AutoRouter());
	}
	
	public static RouteFactory getInstance(){
		return factory;
	}
	
	public Router getRouter(String key){
		return routes.get(key);
	}
	

}
