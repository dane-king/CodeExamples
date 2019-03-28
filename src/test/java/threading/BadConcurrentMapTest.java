package threading;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.llorllale.cactoos.matchers.RunsInThreads;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BadConcurrentMapTest {

    private final List<String> names=Arrays.asList("Bob",
            "Sue",
            "Bill",
            "Mary",
            "Alice",
            "Susan",
            "Jose",
            "Shari",
            "Dinesh");

    @Before
    public void setUp() {

    }

    @Test
    public void onlyAddUniqueNames() {
        BadConcurrentMap badConcurrentMap = new BadConcurrentMap();
        MatcherAssert.assertThat(t ->{
            String name = getName();
            t.addUniqueString(name);
            //System.out.println(Collections.frequency(t.getNames(),name) + " " + t.getNames() + " " + name);
            return Collections.frequency(t.getNames(),name)==1;
        }, new RunsInThreads<>(badConcurrentMap, 1000));
        //System.out.println(badConcurrentMap.getNames());
    }

    private String getName(){
        Collections.shuffle(names);
        return names.get(0);
    }


}
