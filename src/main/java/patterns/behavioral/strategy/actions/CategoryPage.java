package patterns.behavioral.strategy.actions;

public class CategoryPage implements Dispatcher {

	public Response dispatch(final String url, final String... params) {
		String responseUrl = "category" + url;
		for (String param : params) {
			responseUrl += "|" + param;
		}
		return new Response(responseUrl);
	}

}
