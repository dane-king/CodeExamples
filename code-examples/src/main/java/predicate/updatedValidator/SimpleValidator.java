package predicate.updatedValidator;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class SimpleValidator<T> implements Validate<T> {
    private final Predicate<T> predicate;
    private final UnaryOperator<String> errorMessageHandler;

    public SimpleValidator(Predicate<T> predicate, UnaryOperator<String> errorMessageHandler) {
        this.predicate = predicate;
        this.errorMessageHandler = errorMessageHandler;
    }

    @Override
    public boolean validate(String key, T objectToValidate) {
        if (predicate.test(objectToValidate))
            return true;
        throw new IllegalArgumentException(errorMessageHandler.apply(key));
    }
}
