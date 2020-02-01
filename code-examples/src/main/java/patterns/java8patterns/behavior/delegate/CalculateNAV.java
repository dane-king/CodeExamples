package patterns.java8patterns.behavior.delegate;

import java.math.BigDecimal;
import java.util.function.Function;

public class CalculateNAV {
    private Function<String, Double> priceFinder;

    public CalculateNAV(Function<String,Double> priceFinder) {
        this.priceFinder = priceFinder;
    }

    public Double compute(String tck, int shares) {
        return BigDecimal.valueOf(priceFinder.apply(tck))
                .multiply(new BigDecimal(shares))
                .doubleValue();
    }
}
