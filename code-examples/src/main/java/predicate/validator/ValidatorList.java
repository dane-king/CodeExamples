package predicate.validator;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ValidatorList<T> {
    private final PredicateMessage<T> alwaysFalse = new PredicateMessage<>(s->true, s -> "All Validations Passed");

    //May need to implement clear method if not using a new one every time
    List<PredicateMessage<T>> predicates=new ArrayList<>();

    public ValidatorList<T> addPredicate(Predicate<T> predicate, UnaryOperator<String> errorMessageBuilder) {
        predicates.add(new PredicateMessage<>(predicate,errorMessageBuilder));
        return this;
    }

    public String validate(Pair<String,T> keyValue) {
        if(predicates.isEmpty()){
            return "No Validations were Executed";
        }
        return predicates.stream()
                .filter(p-> p.isNotValid(keyValue.getValue()))
                .findFirst()
                .map(p->p.getMessage(keyValue.getKey()))
                .orElse("All Validations Passed");
    }


    public void validateThrow(Pair<String,T> keyValue) throws IllegalArgumentException{
        predicates.forEach(p->{
            if(p.isNotValid(keyValue.getValue())){
                throw new IllegalArgumentException(p.getMessage(keyValue.getKey()));
            }
        });

    }

    public List<String> validateAll(Pair<String, T> keyValue) {
        return predicates.stream()
                .filter(p-> p.isNotValid(keyValue.getValue()))
                .map(p->p.getMessage(keyValue.getKey()))
                .collect(Collectors.toList());
    }


    static class PredicateMessage<T> {
        private final Predicate<T> predicate;
        private final UnaryOperator<String> errorMessageBuilder;

        public PredicateMessage(Predicate<T> predicate, UnaryOperator<String> errorMessageBuilder) {
            this.predicate = predicate;
            this.errorMessageBuilder = errorMessageBuilder;
        }
        public boolean isNotValid(T item) {
            return !predicate.test(item);
        }

        public String getMessage(String key) {
            return errorMessageBuilder.apply(key);
        }

    }
}
