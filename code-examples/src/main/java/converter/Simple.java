package converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("root")
public class Simple {
    private int x;
    private int y;

    private String name;

    @JsonCreator
    public Simple(@JsonProperty("x") int x, @JsonProperty("y") int y, @JsonProperty("name") String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Simple{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}