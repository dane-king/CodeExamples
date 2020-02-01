package patterns.java8patterns.iterator;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Sample {
    public static int factorialIterator(int number){
        return IntStream
                .rangeClosed(1, number)
                .reduce(1,(product,index)->product*index);
    }

    public static Function<Integer,Integer> factorialIteratorCurry(IntBinaryOperator reduceFn, int start){
        return number ->IntStream
                .rangeClosed(1, number)
                .reduce(start, reduceFn);
    }
}
