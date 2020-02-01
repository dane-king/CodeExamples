package patterns.java8patterns.iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class SampleTest {

    @Before
    public void setUp() {

    }

    @Test
    public void factorialIteratorsOfNumbersIs120() {
        assertThat(Sample.factorialIterator(5),equalTo(120));
    }

    @Test
    public void factorialIteratorsOfNumbersWithReduceProductFunctionIs120() {
        Function<Integer, Integer> reduceFn = Sample.factorialIteratorCurry((product, index) -> product * index, 1);
        assertThat(reduceFn.apply(5),equalTo(120));
    }

    @Test
    public void factorialIteratorsOfNumbersWithReduceSumFunctionIs120() {
        Function<Integer, Integer> reduceFn = Sample.factorialIteratorCurry((product, index) -> product + index, 0);
        assertThat(reduceFn.apply(5),equalTo(15));
    }


}
