package patterns.java8patterns.structural.adapter;

public class Triangle implements OtherShape{
    private String action;

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public void drawShape() {
        this.action = "Triangle draw";

    }

    @Override
    public int other() {
        return 5;
    }
}
