package domain.common;

import java.util.Optional;

public class Person {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public Optional<Address> getSafeAddress(){
        return Optional.ofNullable(address);
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
