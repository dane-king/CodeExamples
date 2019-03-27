package streams;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class CollectUtilsTest {

    private CollectUtils collectUtils;


    @Before
    public void setUp() {
        collectUtils = new CollectUtils();

    }

    @Test
    public void partitionEvenShouldHaveTrueTwoFalseThree () {
        Map<Boolean, List<Integer>> sumEvens=collectUtils.getPartitionedList(getNumberList(10),evenPredicate);
        List<Integer> evens=sumEvens.get(true);
        List<Integer> odds=sumEvens.get(false);
        assertThat(evens,contains(2,4,6,8,10));
        assertThat(odds,contains(1,3,5,7,9));
    }

    @Test
    public void groupingWillHave3Levels () {
        Map<Boolean, List<Integer>> groups=collectUtils.getGroupedList(getNumberList(10), groupingFn);
        List<Integer> firstLevel=groups.get("FirstLevel");
        List<Integer> secondLevel=groups.get("SecondLevel");
        List<Integer> thirdLevel=groups.get("ThirdLevel");
        assertThat(firstLevel,contains(1,2,3));
        assertThat(secondLevel,contains(4,5,6));
        assertThat(thirdLevel,contains(7,8,9,10));
    }
    private Function<Integer, String> groupingFn=num->{
        String level="";
        switch (num){
            case 1:
            case 2:
            case 3:
                level="FirstLevel";
                break;
            case 4:
            case 5:
            case 6:
                level="SecondLevel";
                break;
            default:
                level="ThirdLevel";
                break;

        }
        return level;
    };

    @Test
    public void sumEvenShouldBe30 () {
        int sumEvens=collectUtils.getPartitionedList(getNumberList(10), zeroIfFalse(evenPredicate),0);
        assertThat(sumEvens,equalTo(30));
    }

    @Test
    public void sumOddShouldBe30 () {
        int sumEvens=collectUtils.getPartitionedList(getNumberList(10), zeroIfFalse(oddPredicate),0);
        assertThat(sumEvens,equalTo(25));

    }

    @Test
    public void createCSVProducesCSVString(){
        List<String> names= Arrays.asList("Bob", "Sue","John","Stacy","Alice");
        assertThat(collectUtils.getCSV(names),equalTo("Bob,Sue,John,Stacy,Alice"));
    }

    @Test
    public void customCollectorProducesQuotedCSVString(){
        List<String> names= Arrays.asList("Bob", "Sue","John","Stacy","Alice");
        assertThat(collectUtils.getQuotedCSV(names),equalTo("\"Bob\",\"Sue\",\"John\",\"Stacy\",\"Alice\""));
    }


    private Predicate<Integer> evenPredicate = (x) -> x % 2 == 0;
    private Predicate<Integer> oddPredicate = evenPredicate.negate();



    private List<Integer> getNumberList(int limit){
        return IntStream
                .rangeClosed(1, limit)
                .boxed()
                .collect(Collectors.toList());
    }

    private Function<Integer,Integer> zeroIfFalse(Predicate<Integer> predicate){
        return t->predicate.test(t)?t:0;
    }
}
