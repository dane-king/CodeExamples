package predicate.updatedValidator;

@FunctionalInterface
public interface Validate<T> {
    boolean validate(String key, T objectToValidate);

    default Validate<T> and(Validate<T> next) {
        return new ChainedValidator<>(this, next);
    }

}
