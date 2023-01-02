package validator;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    @Test
    void shouldValidate() {
        User user=new User();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        List<String> violationMessages= violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());

        assertEquals("Person was not initialized correctly", violationMessages.get(0));
    }
}