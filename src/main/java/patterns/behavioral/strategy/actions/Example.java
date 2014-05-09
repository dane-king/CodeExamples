package patterns.behavioral.strategy.actions;

import java.util.HashMap;
import java.util.Map;

public class Example {
	private final Map<String, ActionMapper> operations = new HashMap<String, ActionMapper>();
	private final String name;
	private final String url;
	private String[] params;

	public Example(final String name, final String url) {
		super();
		this.name = name;
		this.url = url;
		setupOperations();
	}

	public void setParams(final String... params) {
		this.params = params;
	}

	public Map<String, ActionMapper> getOperations() {
		return operations;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public void makeCall() {
		ActionMapper actionMapper = operations.get(name);
		Response response = actionMapper.dispatch(url, params);
		System.out.println(response.getName());
	}

	public void setupOperations() {
		operations.put("product", new ActionMapper(new ProductPage()));
		operations.put("category", new ActionMapper(new CategoryPage()));
	}

	public static void main(final String[] args) {
		Example example = new Example("product", "p_page");
		example.setParams("2", "4");
		example.makeCall();
		example = new Example("category", "c_page");
		example.setParams("1", "2", "3");
		example.makeCall();
	}
}
