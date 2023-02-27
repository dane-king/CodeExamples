package patterns.ddd.acl.legacy;

import lombok.Value;

@Value
public class LegacyPerson {
    private int id;
    private String firstName;
    private String lastName;
    private String department;
}
