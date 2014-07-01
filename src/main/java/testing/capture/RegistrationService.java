package testing.capture;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationService {
	private final Mailer mailer;
	private final List<String> offers;

	private RegistrationService(final Mailer mailer, final List<String> offers) {
		this.offers = offers;
		this.mailer = mailer;
	}

	public void register(final User user) {
		Map<String, Object> model = createModel(user);
		mailer.send(user.getEmail(), "welcome.vm", model);
	}

	private Map<String, Object> createModel(final User user) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("name", user.getName());
		if (!offers.isEmpty()) {
			model.put("offer", offers.toArray());
		}
		return model;
	}

}
