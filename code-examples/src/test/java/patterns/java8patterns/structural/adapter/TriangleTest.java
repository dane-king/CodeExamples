package patterns.java8patterns.structural.adapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class TriangleTest {

    private Triangle triangle;

    @Before
    public void setUp() {
        triangle =new Triangle();
    }

    @Test
    public void shouldHaveOther() {
        assertThat(triangle.other(), equalTo(5));
    }

    @Test
    public void shouldPerformDrawAction() {
        triangle.drawShape();
        assertThat(triangle.getAction(), equalTo("Triangle draw"));
    }
}
