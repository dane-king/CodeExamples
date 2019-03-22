package patterns.java8patterns.behavior.strategy;

import java.util.List;
import java.util.function.Function;

public class Sample {
    public static final Function<Double,Double> happyHourPricing=(price)->price*0.5;
    public static final Function<Double,Double> normalPricing=(price)->price;

    /**
     *
     * @param priceStrategy to use, ie happyHour, normal...
     * @return A function that takes in a list of drink prices
     * and sums the total based on price strategy
     */
    public static Function<List<Double>, Double> calculateSum(Function<Double, Double> priceStrategy){
        return (List<Double> drinks)->drinks
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .map(priceStrategy::apply)
                    .sum();

    }
}
