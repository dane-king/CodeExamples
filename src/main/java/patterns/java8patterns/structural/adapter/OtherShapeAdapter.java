package patterns.java8patterns.structural.adapter;

public class OtherShapeAdapter implements Shape {
    private OtherShape otherShape;

    public String getAction() {
        return otherShape.getAction();
    }

    public OtherShapeAdapter(OtherShape otherShape) {
        this.otherShape = otherShape;
    }

    @Override
    public void draw() {
        otherShape.drawShape();
    }

    @Override
    public String description() {
        return otherShape.getClass().getSimpleName();
    }
}
