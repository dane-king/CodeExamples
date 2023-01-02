package patterns.behavioral.command.factory;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RouteFactoryTest {
	private RouteFactory factory;
	
	@Before
	public void setup(){
		factory=RouteFactory.getInstance();
	}
	@Test
	public void testGetAutoRouter() {
		Router router=factory.getRouter(AutoRouter.KEY);
		assertNotNull("Router should not be null",router);
		assertTrue(router instanceof AutoRouter);
		
	}
	
	@Test
	public void testAutoHandlesParams() {
		Router router=factory.getRouter(AutoRouter.KEY);
		boolean status=router.handle(buildAutoParams());
		assertTrue(status);

	}
	
	@Test
	public void testPropertyHandlesParams() {
		Router router=factory.getRouter(AutoRouter.KEY);
		boolean status=router.handle(buildPropertyParams());
		assertTrue(status);

	}
	@Test
	public void testGetPropertyRouter() {
		Router router=factory.getRouter(PropertyRouter.KEY);
		assertNotNull("Router should not be null",router);
		assertTrue(router instanceof PropertyRouter);
	}
	
	private  Map<String, String> buildAutoParams() {
		Map<String, String> params=new HashMap<String, String>();
		params.put("auto_one","true");
		params.put("auto_two","blue");
		return params;
	}
	
	private  Map<String, String> buildPropertyParams() {
		Map<String, String> params=new HashMap<String, String>();
		params.put("ppq_one","false");
		params.put("ppq_two","red");
		return params;
	}
	

}
