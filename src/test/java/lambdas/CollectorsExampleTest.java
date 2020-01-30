package lambdas;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

@RunWith(MockitoJUnitRunner.class)
public class CollectorsExampleTest {

    private CollectorsExample collectorsExample;

    @Before
    public void setUp() {
        collectorsExample = new CollectorsExample(1, 15);

    }

    @Test
    public void shouldHaveListOfOdds() {
        assertThat(collectorsExample.getOdd().get(true),contains(1,3,5, 7, 9, 11, 13, 15));
    }
    @Test
    public void shouldHaveRestOfListOfEvens() {
        assertThat(collectorsExample.getOdd().get(false),contains(2,4,6, 8, 10, 12, 14));
    }

    @Test
    public void shouldHaveFizzBuzz() {
        assertThat(collectorsExample.getFizzBuzzGame().get(CollectorsExample.GAME.FIZZBUZZ),contains(15));
    }
    @Test
    public void shouldHaveBuzz() {
        assertThat(collectorsExample.getFizzBuzzGame().get(CollectorsExample.GAME.BUZZ),contains(5,10));
    }
    @Test
    public void shouldHaveFizz() {
        assertThat(collectorsExample.getFizzBuzzGame().get(CollectorsExample.GAME.FIZZ),contains(3,6,9,12));
    }
   @Test
    public void shouldHaveNone() {
        assertThat(collectorsExample.getFizzBuzzGame().get(CollectorsExample.GAME.NONE),contains(1,2,4,7,8,11,13,14));
    }

}
