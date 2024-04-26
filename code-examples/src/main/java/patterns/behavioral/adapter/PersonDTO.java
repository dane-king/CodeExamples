package patterns.behavioral.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDTO {
    private String firstName;
    private String lastName;
    private int age;
}
