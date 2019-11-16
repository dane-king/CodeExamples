package patterns.java8patterns.structural.adapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class CircleTest {

    private Circle circle;

    @Before
    public void setUp() {
        circle =new Circle();
    }

    @Test
    public void shouldHaveCircleDescription() {
        assertThat(circle.description(), equalTo("Circle"));
    }

    @Test
    public void shouldPerformDrawAction() {
        circle.draw();
        assertThat(circle.getAction(), equalTo("Circle draw"));
    }
}
