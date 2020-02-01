package patterns.behavioral.command.factory;

import java.util.HashMap;
import java.util.Map;

public class UsingRouter {
	
	private static Map<String, String> buildAutoParams() {
		Map<String, String> params=new HashMap<String, String>();
		params.put("auto_one","true");
		params.put("auto_two","blue");
		return params;
	}
	
	private static Map<String, String> buildPropertyParams() {
		Map<String, String> params=new HashMap<String, String>();
		params.put("ppq_one","false");
		params.put("ppq_two","red");
		return params;
	}
	
	public static void main(String[] args) {
		RouteFactory factory=RouteFactory.getInstance();
		UsingRouter app=new UsingRouter();
		
		//An actually use case could be URL and RequestMap as inputs to the method
		app.processRoute(factory.getRouter(AutoRouter.KEY), buildAutoParams());
		
		app.processRoute(factory.getRouter(PropertyRouter.KEY), buildPropertyParams());


	}



	public  void processRoute(Router route,
			Map<String, String> params) {
		route.handle(params);
	}
}
