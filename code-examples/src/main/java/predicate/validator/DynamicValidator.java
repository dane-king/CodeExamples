package predicate.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class DynamicValidator<T,K> implements Validator<T>, MessageBuilder<String> {
    private final List<UnaryOperator<String>> errorMsgBuilders=new ArrayList<>();
    private Predicate<T> returnPredicate;

    private final BiFunction<Predicate<T>, UnaryOperator<String>, Predicate<T>>  predicateWrapper = (predicate, msg) -> x->{
        boolean isValid=predicate.test(x);
        //or throw exception here, returning false will short circuit and anyway
        if(!isValid) {
            errorMsgBuilders.add(msg);
        }
        return isValid;
    };

    public DynamicValidator<T,K> andValidation(Predicate<T> predicate, UnaryOperator<String> msg){
        Predicate<T> wrappedPredicate = predicateWrapper.apply(predicate, msg);
        this.returnPredicate=returnPredicate==null?wrappedPredicate:returnPredicate.and(wrappedPredicate);
        return this;
    }

    public DynamicValidator<T,K> orValidation(Predicate<T> predicate, UnaryOperator<String> msg){
        Predicate<T> wrappedPredicate = predicateWrapper.apply(predicate, msg);
        this.returnPredicate=returnPredicate==null?wrappedPredicate:returnPredicate.or(wrappedPredicate);
        return this;
    }

    public boolean validate(T source) {
        errorMsgBuilders.clear();
        return this.returnPredicate.test(source);
    }

    public void validateThrows(String key, T source) throws IllegalArgumentException{
        errorMsgBuilders.clear();
        if(!returnPredicate.test(source)){
            var errMsg=this.getErrorMessages(key).stream().findFirst().orElseThrow();
            //String errMsg = (String) errMsgBuilder.apply(key);
            throw new IllegalArgumentException(errMsg);
        }
    }

    //if key is only used in class, should make it a constructor variable and use the internal state
    public List<String> getErrorMessages(String key) {
        return errorMsgBuilders.stream().map(fn -> fn.apply(key)).collect(Collectors.toUnmodifiableList());
    }
}
