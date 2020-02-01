package lambdas;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MockingTest {
    public static final String EXPECTED_STRING = "Stuff";
    private InternalService internalService;

    @Before
    public void setUp() {
        //can stub interface with one method with a lambda
        internalService = new InternalService(() -> EXPECTED_STRING);

    }

    @Test
    public void shouldGetStuff() {
        assertThat(internalService.getStuff(), equalTo(EXPECTED_STRING));
    }
}
