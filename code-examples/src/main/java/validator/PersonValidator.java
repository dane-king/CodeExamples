package validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonValidator implements ConstraintValidator<PersonIsValid, Person> {

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext constraintValidatorContext) {
        return person!=null && person.getAge() !=null && StringUtils.isNotBlank(person.getName());
    }
}
