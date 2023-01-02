package predicate.updatedValidator;

public class ChainedValidator<T> implements Validate<T> {
    private final Validate<T> current;
    private final Validate<T> next;

    public ChainedValidator(Validate<T> current, Validate<T> next) {
        this.current = current;
        this.next = next;
    }

    @Override
    public boolean validate(String key, T objectToValidate) {
        return current.validate(key, objectToValidate) && next.validate(key, objectToValidate);
    }
}
