package predicate.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StaticValidator implements Validator<String>, MessageBuilder<String> {
    private final List<String> reasons=new ArrayList<>();

    //This also could be passed in the constructor if it needs to change
    private final BiFunction<Predicate<String>, String, Predicate<String>> predicateWrapper= (predicate, msg) -> x->{
        boolean isValid=predicate.test(x);
        //or throw exception here, returning false will short circuit and anyway
        if(!isValid) reasons.add(msg);
        return isValid;
    };

    private final Predicate<String> startWithBTest = (x) -> x.startsWith("B");
    private final Predicate<String> nonNullTest = Objects::nonNull;
    private final Predicate<String> containsTestTest = (x) -> x.contains("Test");


    Predicate<String> notNull=predicateWrapper.apply(nonNullTest,"%s is Null");
    Predicate<String> startsWithB=predicateWrapper.apply(startWithBTest,"%s does not start with B");
    Predicate<String> containsTest=predicateWrapper.apply(containsTestTest,"%s does not contain Test");

    @Override
    public boolean validate(String source) {
        return notNull.and(containsTest).and(startsWithB).test(source);
    }

    @Override
    public List<String> getErrorMessages(String key) {
        return reasons.stream().map(s->String.format(s,key)).collect(Collectors.toUnmodifiableList());
    }

}
