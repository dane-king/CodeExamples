package patterns.java8patterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
    List<Shape> shapes=new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public List<Shape> getShapes() {
        return new ArrayList<>(shapes);
    }

    public void draw() {
        shapes.forEach(Shape::draw);
    }
}
