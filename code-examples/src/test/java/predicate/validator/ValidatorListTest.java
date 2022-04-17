package predicate.validator;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorListTest {

    private final Pair<String, String> nullItem = Pair.of("item", null);
    private final Function<String, Pair<String, String>> isCurrencyValid = currency -> Pair.of("money", currency);

    Predicate<String> isNull = Objects::nonNull;
    Predicate<String> isUSD = "USD"::equals;
    UnaryOperator<String> isRequired = s -> s + " is required";
    UnaryOperator<String> mustBeUSD = s -> s + " must be USD";

    private ValidatorList<String> validatorList;

    @BeforeEach
    void setUp() {
        validatorList = new ValidatorList<>();
    }

    @Test
    void shouldBeAbleToValidateWithOnePredicate() {
        validatorList.addPredicate(isNull, isRequired);
        String predicateMessage = validatorList.validate(nullItem);
        assertEquals("item is required", predicateMessage);
    }

    @Test
    void shouldGetSuccessMessageWithPassingPredicates() {
        validatorList.addPredicate(Objects::isNull, s -> s + " is not null");
        String predicateMessage = validatorList.validate(nullItem);
        assertEquals("All Validations Passed", predicateMessage);
    }

    @Test
    public void testDanesValidatorList() {
        validatorList.addPredicate(isNull, isRequired)
                .addPredicate(isUSD, mustBeUSD);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> validatorList.validateThrow(isCurrencyValid.apply("JPY")));
        assertEquals("money must be USD", thrown.getMessage());
    }

    @Test
    public void shouldGetListOfAllErrors() {
        validatorList.addPredicate(isNull, isRequired)
                .addPredicate(isUSD, mustBeUSD)
                .addPredicate(s -> s.startsWith("U"), s -> s + " should start with U");
        List<String> predicateMessage = validatorList.validateAll(isCurrencyValid.apply("CAD"));
        assertTrue(predicateMessage.contains("money must be USD"));
        assertTrue(predicateMessage.contains("money should start with U"));
    }

    @Test
    void shouldNotBeAbleToValidateWithNoPredicates() {
        String predicateMessage = validatorList.validate(nullItem);
        assertEquals("No Validations were Executed", predicateMessage);
    }

}
