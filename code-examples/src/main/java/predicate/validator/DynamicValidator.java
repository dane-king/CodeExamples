package predicate.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class DynamicValidator<T> implements Validator<T> {
    private final List<String> reasons=new ArrayList<>();
    private Predicate<T> returnPredicate;

    private final BiFunction<Predicate<T>, String, Predicate<T>>  predicateWrapper;

    //Might be able to pass some info in constructor to make it more dynamic
    public DynamicValidator() {
        predicateWrapper = (predicate, msg) -> x->{
            boolean isValid=predicate.test(x);
            //or throw exception here, returning false will short circuit and anyway
            if(!isValid) reasons.add(msg);
            return isValid;
        };
    }

    public void andValidation(Predicate<T> predicate, String msg){
        Predicate<T> wrappedPredicate = predicateWrapper.apply(predicate, msg);
        returnPredicate=returnPredicate==null?wrappedPredicate:returnPredicate.and(wrappedPredicate);
    }
    public void orValidation(Predicate<T> predicate, String msg){
        Predicate<T> wrappedPredicate = predicateWrapper.apply(predicate, msg);
        returnPredicate=returnPredicate==null?wrappedPredicate:returnPredicate.or(wrappedPredicate);
    }

    public boolean validate(T source) {
        return returnPredicate.test(source);
    }

    public List<String> getReasons() {
        return Collections.unmodifiableList(reasons);
    }
}
