package testing.capture;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RegistrationServiceTest {
	@Mock
	private Mailer mailer;
	@Mock
	private User user;
	@Mock
	private List<String> offers;
	@Mock
	private Map<String, Object> model;

	@InjectMocks
	private RegistrationService service;

	@Captor
	private ArgumentCaptor<Map<String, Object>> modelCaptor;

	private final String[] offerArray = { "Offer1", "Offer2" };

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		setupOffer();
		setupUser();
		setupModel();
	}

	private void setupOffer() {
		when(offers.toArray()).thenReturn(offerArray);
		when(offers.get(1)).thenReturn("Offer2");
	}

	private void setupUser() {
		when(user.getName()).thenReturn("Bob");
		when(user.getEmail()).thenReturn("bob@email.com");
	}

	private void setupModel() {
		when(model.get("name")).thenReturn("Bob");
		when(model.get("offer")).thenReturn(offerArray);
	}

	@Test
	public void shouldSendRegistrationWelcomeUser() {
		service.register(user);
		verify(mailer).send(eq("bob@email.com"), eq("welcome.vm"), modelCaptor.capture());
		assertThat((String) modelCaptor.getValue().get("name"), equalTo("Bob"));
	}

	@Test
	public void shouldSendRegistrationWithOffersWhenAvailable() {
		service.register(user);
		verify(mailer).send(eq("bob@email.com"), eq("welcome.vm"), modelCaptor.capture());
		assertThat((String[]) modelCaptor.getValue().get("offer"), equalTo(offerArray));
	}

}
