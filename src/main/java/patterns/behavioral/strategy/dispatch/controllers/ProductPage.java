package patterns.behavioral.strategy.dispatch.controllers;

public class ProductPage implements Dispatcher {

	public Response dispatch(final String url, final String... params) {
		String responseUrl = "product" + url;
		for (String param : params) {
			responseUrl += "&" + param;
		}
		return new Response(responseUrl);
	}

}
