package predicate.validator;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class SamsValidatorChainTest {
    Predicate<String> isNull = Objects::isNull;
    Predicate<String> isUSD = "USD"::equals;
    UnaryOperator<String> isRequired = s -> s + " is required";
    UnaryOperator<String> mustBeUsd = s -> s + " must be USD";

    @Test
    public void testSamValidatorChain() {
        var nullCheckChain = SamsValidatorChain.createValidator(isNull, isRequired);
        var usdCheckChain = SamsValidatorChain.createValidator(isUSD, mustBeUsd);

        try {
            nullCheckChain
                    .compose(usdCheckChain)
                    .apply(null)
                    .isValid("money", "JPY");
        } catch (IllegalArgumentException e) {
            assertEquals("money must be USD", e.getMessage());
        }
    }
}