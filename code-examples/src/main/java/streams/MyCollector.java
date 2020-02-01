package streams;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Not very useful, can do this all with joining
 * just showing example
 */
public class MyCollector implements Collector<String, StringBuilder, String> {

    private CharSequence delimiter;

    public MyCollector(CharSequence delimiter) {
        this.delimiter = delimiter;
    }

    public static final String QUOTE = "\"";

    private static String finish(StringBuilder sb) {
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public Supplier<StringBuilder> supplier() {
        //new instance of accumulator, does not have to be thread safe
        //as long as no side effects, etc, parallel operations will operate
        //on this and combine and finish at the end
        return ()->new StringBuilder();
    }

    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
        //do the work of adding to the accumulator
        return (sb, s)->sb
                .append(QUOTE)
                .append(s)
                .append(QUOTE).append(delimiter);
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        //combiner is called after parallel
        return StringBuilder::append;
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        //finisher is last thing called
        return MyCollector::finish;
    }

    @Override
    public Set<Characteristics> characteristics() {
        //set of possible characteristics
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
