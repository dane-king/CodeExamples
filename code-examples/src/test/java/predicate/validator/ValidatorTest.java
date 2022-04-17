package predicate.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    private final Function<String, UnaryOperator<String>> shouldStartWith = letter -> s -> s + " should start with " + letter;
    private final UnaryOperator<String> shouldStartWithB = shouldStartWith.apply("B");
    private final UnaryOperator<String> shouldStartWithC = shouldStartWith.apply("C");
    private final UnaryOperator<String> shouldStartWithZ = shouldStartWith.apply("Z");
    private final UnaryOperator<String> itemIsNull = s -> s + " is Null";


    private DynamicValidator<String,String> dynamicValidator;
    private StaticValidator staticValidator;

    @BeforeEach
    void setUp() {
        dynamicValidator = new DynamicValidator<>();
        staticValidator = new StaticValidator();
    }

    @Test
    void shouldValidateNotNullItem() {
        assertFalse(staticValidator.validate("A String"));

    }

    @Test
    void shouldInValidateNullItem() {
        assertFalse(staticValidator.validate(null));
        List<String> errorMessages = staticValidator.getErrorMessages("key");
        assertEquals("key is Null", errorMessages.get(0));
        assertEquals(1, errorMessages.size());
    }

    @Test
    void shouldValidateItemContainsTest() {
        assertFalse(staticValidator.validate("A String Test"));
    }

    @Test
    void shouldValidateItemContainsTestAndStartsWithB() {
        assertTrue(staticValidator.validate("B String Test"));
    }

    @Test
    void shouldValidateAndItemsDynamically() {
        dynamicValidator.andValidation(Objects::nonNull, itemIsNull)
                .andValidation(x -> x.startsWith("C"), shouldStartWithC);
        assertTrue(dynamicValidator.validate("C String"));
        assertFalse(dynamicValidator.validate(null));
        assertFalse(dynamicValidator.validate("A String"));
    }

    @Test
    void shouldValidateWithMessage() {
        String key = "String";
        dynamicValidator.andValidation(Objects::nonNull, itemIsNull)
                .andValidation(x -> x.startsWith("C"), shouldStartWithC);
        assertFalse(dynamicValidator.validate("D String"));
        assertEquals("String should start with C", dynamicValidator.getErrorMessages(key).get(0));

        assertFalse(dynamicValidator.validate(null));
        assertEquals("String is Null", dynamicValidator.getErrorMessages(key).get(0));

    }


    @Test
    void shouldValidateOrItemsDynamically() {
        dynamicValidator
                .orValidation(x -> x.startsWith("B"), shouldStartWithB)
                .orValidation(x -> x.startsWith("C"), shouldStartWithC);
        assertTrue(dynamicValidator.validate("C String"));
        assertTrue(dynamicValidator.validate("B String"));
        assertTrue(dynamicValidator.validate("B String"));
        assertFalse(dynamicValidator.validate("D String"));
    }

    @Test
    void shouldValidateBothAndOrItemsDynamically() {
        dynamicValidator.orValidation(x -> x.startsWith("B"), shouldStartWithB)
                .orValidation(x -> x.startsWith("C"), shouldStartWithC)
                .andValidation(x -> x.endsWith("Z"), shouldStartWithZ);
        assertTrue(dynamicValidator.validate("C StringZ"));
        assertTrue(dynamicValidator.validate("B StringZ"));
        assertFalse(dynamicValidator.validate("B String"));
        assertFalse(dynamicValidator.validate("C String"));
        assertFalse(dynamicValidator.validate("D StringZ"));
    }

}