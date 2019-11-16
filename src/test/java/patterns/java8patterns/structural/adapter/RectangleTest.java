package patterns.java8patterns.structural.adapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class RectangleTest {

    private Rectangle rectangle;

    @Before
    public void setUp() {
        rectangle=new Rectangle();
    }

    @Test
    public void shouldHaveRectangleDescription() {
        assertThat(rectangle.description(), equalTo("Rectangle"));
    }

    @Test
    public void shouldPerformDrawAction() {
        rectangle.draw();
        assertThat(rectangle.getAction(), equalTo("Rectangle draw"));
    }
}
