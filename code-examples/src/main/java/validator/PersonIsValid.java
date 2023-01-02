package validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= PersonValidator.class)
@Documented
public @interface PersonIsValid {
    String message() default "Person was not initialized correctly";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

