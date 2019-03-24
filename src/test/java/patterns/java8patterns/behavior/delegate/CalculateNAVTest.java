package patterns.java8patterns.behavior.delegate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class CalculateNAVTest {

    private CalculateNAV calculateNAV;

    @Before
    public void setUp() {


    }

    @Test
    public void computeNAVOf100WithPriceOf2Is200() {
        calculateNAV = new CalculateNAV(x->2.0);
        assertThat(calculateNAV.compute("TCK",100),equalTo(200.0));
    }

    @Test
    public void computeNAVOf100WithPriceFinderOf4Is400() {
        calculateNAV=new CalculateNAV(ticker->4.0);
        assertThat(calculateNAV.compute("TCK",100),equalTo(400.0));
    }

    @Test
    public void computeNAVOf100StockFetcherIs400() {
        calculateNAV=new CalculateNAV(StockFetcher::getStockPrice);
        assertThat(calculateNAV.compute("ORCL",100),equalTo(3555.0));
    }

    @Test
    public void computeNAVOf100NotFoundStockFetcherIs0() {
        calculateNAV=new CalculateNAV(StockFetcher::getStockPrice);
        assertThat(calculateNAV.compute("XXX",100),equalTo(0D));
    }




}
