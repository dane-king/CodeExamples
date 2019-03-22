package patterns.java8patterns.behavior.strategy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class SampleTest {

    private List<Double> drinks;

    @Before
    public void setUp() {
        drinks = Arrays.asList(2.50,5.0,6.0);
    }

    @Test
    public void happyHourPricingIsHalfOff() {
        assertThat(Sample.calculateSum(Sample.happyHourPricing).apply(drinks),equalTo(6.75));

    }
    @Test
    public void normalPricingIsSum() {
        assertThat(Sample.calculateSum(Sample.normalPricing).apply(drinks),equalTo(13.5));

    }

}
