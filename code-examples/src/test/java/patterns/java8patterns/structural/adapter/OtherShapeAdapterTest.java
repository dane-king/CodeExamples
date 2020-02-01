package patterns.java8patterns.structural.adapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class OtherShapeAdapterTest {

    private Triangle triangle;
    private OtherShapeAdapter adapter;

    @Before
    public void setUp() {

        triangle =new Triangle();
        adapter=new OtherShapeAdapter(triangle);
    }

    @Test
    public void shouldHaveTriangleDescription() {
        assertThat(adapter.description(), equalTo("Triangle"));
    }

    @Test
    public void shouldPerformDrawAction() {
        adapter.draw();
        assertThat(triangle.getAction(), equalTo("Triangle draw"));
    }
}
