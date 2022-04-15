package predicate.validator;

import java.util.List;

public interface Validator<T> {
    boolean validate(T source);

    List<String> getReasons();
}
