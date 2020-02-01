package patterns.java8patterns.structural.adapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DrawingTest {

    private Drawing drawing;
    @Mock
    private Circle circle;
    @Mock
    private Rectangle rectangle;
    @Mock
    private Triangle triangle;

    @Before
    public void setUp() {
        drawing = new Drawing();

    }

    @Test
    public void shouldBeAbleToAddShape() {
        addShapes(circle);
        assertThat(drawing.getShapes(), hasItem(circle));
    }

    @Test
    public void shouldCopyLists() {
        addShapes(circle);
        List<Shape> shapes=drawing.getShapes();
        shapes.add(rectangle);
        assertThat(drawing.getShapes(), not(equalTo(shapes)));
    }

    @Test
    public void shouldDrawAllShapes() {
        addShapes(circle, rectangle, new OtherShapeAdapter(triangle));
        drawing.draw();
        verify(circle).draw();
        verify(rectangle).draw();
        verify(triangle).drawShape();

    }

    void addShapes(Shape...shapes) {
        for (Shape shape : shapes) {
            drawing.addShape(shape);
        }
    }
}
