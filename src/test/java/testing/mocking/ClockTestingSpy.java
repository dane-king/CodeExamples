package testing.mocking;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ClockTestingSpy {
    private Clock clock;
    private LocalDateTime mockTime;

    @Spy
    private ClockClassToTest classUnderTest;

    @Before
    public void setUp() {
        mockTime = LocalDateTime.of(2018, 11, 10, 12, 0);
        clock=Clock.fixed(mockTime.toInstant(ZoneOffset.UTC),ZoneId.systemDefault());
        doReturn(mockTime.toLocalDate()).when(classUnderTest).today();
    }


    @Test
    public void shouldChangeLocalDate() {
        assertThat(classUnderTest.getLocalDate(),equalTo(mockTime.toLocalDate()));
    }


}
