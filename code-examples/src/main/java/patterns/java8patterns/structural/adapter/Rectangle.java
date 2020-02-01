package patterns.java8patterns.structural.adapter;

public class Rectangle implements Shape {
    private String action;

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public void draw() {
        this.action = description() + " draw";
    }



    @Override
    public String description() {
        return "Rectangle";
    }

}
