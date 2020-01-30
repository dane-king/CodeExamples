package lambdas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorsExample {
    private final IntStream numStream;

    public enum GAME {FIZZ, BUZZ, FIZZBUZZ, NONE}

    ;

    public CollectorsExample(int start, int end) {
        this.numStream = IntStream.range(start, end + 1);
    }

    public Map<Boolean, List<Integer>> getOdd() {
        return numStream
                .boxed()
                .collect(Collectors.partitioningBy(num -> num % 2 != 0));
    }

    public Map<GAME, List<Integer>> getFizzBuzzGame() {
        return numStream.boxed().collect(Collectors.groupingBy(this::getFizzBuzz));
    }

    private GAME getFizzBuzz(int value) {
        boolean divisibleBy5=value%5==0;
        boolean divisibleBy3=value%3==0;
        if (divisibleBy3 && divisibleBy5) {
            return GAME.FIZZBUZZ;
        } else if (divisibleBy3) {
            return GAME.FIZZ;
        } else if(divisibleBy5) {
            return GAME.BUZZ;
        }
        return GAME.NONE;
    }



}
