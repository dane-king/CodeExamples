package predicate.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    private DynamicValidator<String> dynamicValidator;
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
        assertTrue(staticValidator.getReasons().contains("Item is null"));
        assertEquals(1, staticValidator.getReasons().size());
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
        dynamicValidator.andValidation(Objects::nonNull, "Item is null");
        dynamicValidator.andValidation(x->x.startsWith("C"), "Item should start with C");
        assertTrue(dynamicValidator.validate("C String"));
        assertFalse(dynamicValidator.validate(null));
        assertFalse(dynamicValidator.validate("A String"));
    }
    @Test
    void shouldValidateOrItemsDynamically() {
        dynamicValidator.orValidation(x->x.startsWith("B"), "Item should start with B");
        dynamicValidator.orValidation(x->x.startsWith("C"), "Item should start with C");
        assertTrue(dynamicValidator.validate("C String"));
        assertTrue(dynamicValidator.validate("B String"));
        assertTrue(dynamicValidator.validate("B String"));
        assertFalse(dynamicValidator.validate("D String"));
    }

    @Test
    void shouldValidateBothAndOrItemsDynamically() {
        dynamicValidator.orValidation(x->x.startsWith("B"), "Item should start with B");
        dynamicValidator.orValidation(x->x.startsWith("C"), "Item should start with C");
        dynamicValidator.andValidation(x->x.endsWith("Z"), "Item should end with Z");
        assertTrue(dynamicValidator.validate("C StringZ"));
        assertTrue(dynamicValidator.validate("B StringZ"));
        assertFalse(dynamicValidator.validate("B String"));
        assertFalse(dynamicValidator.validate("C String"));
        assertFalse(dynamicValidator.validate("D StringZ"));
    }

}