package validator;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class User {
    @NotNull
    private UUID id=UUID.randomUUID();

    @PersonIsValid
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
