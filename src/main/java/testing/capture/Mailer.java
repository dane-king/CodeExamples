package testing.capture;

import java.util.Map;

public interface Mailer {
	void send(final String to, final String template, final Map<String, Object> model);

}
