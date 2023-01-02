package validator;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    private Person person=new Person("Fred Jones", 25);
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Test
    void shouldNotBeAbleToAddBlankItems() {
        person.addItem("");
        List<String> violationMessages= getValidationMessages().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        assertEquals("must not be blank", violationMessages.get(0));
    }

    @Test
    void shouldValidateNameAndAge() {
        person=new Person("",null);
        String[] expectedValues={ "Age cannot be null", "Name cannot be blank"};
        assertArrayEquals(expectedValues, getValidationMessages().stream().map(ConstraintViolation<Person>::getMessage).toArray());
    }

    private Set<ConstraintViolation<Person>> getValidationMessages() {
        return validator.validate(person);
    }
}