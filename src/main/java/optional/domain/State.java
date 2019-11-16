package optional.domain;

public class State {
    private String abbr;
    private String name;

    public State(String abbr, String name) {
        this.abbr = abbr;
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getName() {
        return name;
    }
}
