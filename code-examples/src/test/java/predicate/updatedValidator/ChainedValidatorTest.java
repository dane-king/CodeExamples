package predicate.updatedValidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.UnaryOperator;

class ChainedValidatorTest {

    UnaryOperator<String> nonNullErrorMessageBuilder = s -> s + " must not be null";
    private final Validate<String> nonNullValidator = new SimpleValidator<>(s -> !Objects.isNull(s), nonNullErrorMessageBuilder);

    UnaryOperator<String> mustBeUSD = s -> s + " must be USD";
    private final Validate<String> mustBeUSDValidator = new SimpleValidator<>("USD"::equals, mustBeUSD);

    UnaryOperator<String> mustBeJPY = s -> s + " must be JPY";
    private final Validate<String> mustBeJPYValidator = new SimpleValidator<>("JPY"::equals, mustBeJPY);

    @Test
    public void testValidator() {
        try {
            nonNullValidator
                    .and(mustBeUSDValidator)
                    .validate("money", "JPY");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("money must be USD", e.getMessage());
        }
    }

    @Test
    public void testThreeChainedValidator() {
        try {
            nonNullValidator
                    .and(mustBeUSDValidator)
                    .and(mustBeJPYValidator)
                    .validate("money", "USD");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("money must be JPY", e.getMessage());
        }
    }

}