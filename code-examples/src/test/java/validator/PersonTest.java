package validator;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

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
        String[] expectedValues={ "Name cannot be blank","Age cannot be null", };
        String[] exceptions= getValidationMessages().stream().map(ConstraintViolation<Person>::getMessage).toArray(String[]::new);
        assertThat(exceptions, Matchers.arrayContainingInAnyOrder(expectedValues));
    }

    private Set<ConstraintViolation<Person>> getValidationMessages() {
        return validator.validate(person);
    }
}