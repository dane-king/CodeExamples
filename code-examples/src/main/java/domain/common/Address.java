package domain.common;

import java.util.Objects;

public class Address {
    private State state;
    private String street1;
    private String zip;
    private String street2;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(state, address.state) &&
                Objects.equals(street1, address.street1) &&
                Objects.equals(zip, address.zip) &&
                Objects.equals(street2, address.street2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, street1, zip, street2);
    }
}
