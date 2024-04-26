package patterns.behavioral.adapter;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import utils.ReplaceCamelCase;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(ReplaceCamelCase.class)
class PersonMapperTest {
    @Test
    void shouldConvertDtoToEntity() {
        PersonDTO personDTO=new PersonDTO("first", "last", 25);
        assertEquals(new Person(new Name("first", "last"), 25), new PersonMapper().toEntity(personDTO));
    }
    @Test
    void shouldConvertEntityToDto() {
        Person person=new Person(new Name("first", "last"), 25);
        assertEquals(new PersonDTO("first", "last", 25), new PersonMapper().toDto(person));
    }

}