package patterns.java8patterns.structural.adapter;

public class Circle implements Shape{
    private String action;

    @Override
    public void draw() {
        this.action = description() + " draw";
    }

    @Override
    public String description() {
        return "Circle";
    }
    @Override
    public String getAction() {
        return this.action;
    }
}
