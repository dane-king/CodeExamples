package predicate.validator;


import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class SamsValidatorChain<T> {
    private final SamsValidatorChain<T> nextValidator;
    private final Predicate<T> predicate;
    private final UnaryOperator<String> errorMessageBuilder;

    public static <T> UnaryOperator<SamsValidatorChain<T>> createValidator(Predicate<T> predicate,
                                                                           UnaryOperator<String> errorMessageBuilder) {
        return nextValidator -> new SamsValidatorChain<>(predicate, errorMessageBuilder, nextValidator);
    }

    private SamsValidatorChain(Predicate<T> predicate, UnaryOperator<String> errorMessageBuilder,
                               SamsValidatorChain<T> nextValidator) {
       this.predicate = predicate;
       this.errorMessageBuilder = errorMessageBuilder;
       this.nextValidator = nextValidator;
    }

    public boolean isValid(String key, T thingToValidate) throws IllegalArgumentException {
        if (null != nextValidator) {
            nextValidator.isValid(key, thingToValidate);
        }
        if (!predicate.test(thingToValidate)) {
            throw new IllegalArgumentException(errorMessageBuilder.apply(key));
        }
        return true;
    }
}
