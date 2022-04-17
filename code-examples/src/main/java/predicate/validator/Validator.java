package predicate.validator;

public interface Validator<T> {
    boolean validate(T source);
}
