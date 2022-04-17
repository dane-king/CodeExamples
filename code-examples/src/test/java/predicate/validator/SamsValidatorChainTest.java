package predicate.validator;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class SamsValidatorChainTest {
    Predicate<String> isNull = Objects::nonNull;
    Predicate<String> isUSD = "USD"::equals;
    UnaryOperator<String> isRequired = s -> s + " is required";
    UnaryOperator<String> mustBeUsd = s -> s + " must be USD";

    @Test
    public void testSamValidatorChain() {
        var nullCheckChain = SamsValidatorChain.createValidator(isNull, isRequired);
        var usdCheckChain = SamsValidatorChain.createValidator(isUSD, mustBeUsd);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, (() -> nullCheckChain
                .compose(usdCheckChain)
                .apply(null)
                .isValid("money", "JPY")));

        assertEquals("money must be USD", thrown.getMessage());
    }


    @Test
    void shouldReturnBuilder() {
        DynamicValidator<String,String> validator=new DynamicValidator<>();
        validator.andValidation(isUSD, mustBeUsd)
                .andValidation(isNull, isRequired)
                .validate("JPY");
        assertFalse(validator.validate("JPY"));
        assertEquals("money must be USD",validator.getErrorMessages("money").get(0));

    }

    @Test
    public void testDanesValidatorChain() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,()->new DynamicValidator<String,String>()
                .andValidation(isNull, isRequired)
                .andValidation(isUSD, mustBeUsd)
                .validateThrows("money",null));

        assertEquals("money is required", thrown.getMessage());
    }

    @Test
    public void testDanesValidatorList() {
        ValidatorList<String> validatorList=new ValidatorList<>();
        validatorList.addPredicate(isNull, isRequired);
        validatorList.addPredicate(isUSD, mustBeUsd);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                ()-> validatorList.validateThrow(Pair.of("money","JPY")));
        assertEquals("money must be USD", thrown.getMessage());
    }

}
