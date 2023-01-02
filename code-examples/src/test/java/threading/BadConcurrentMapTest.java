package threading;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.llorllale.cactoos.matchers.RunsInThreads;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        }, new RunsInThreads<>(badConcurrentMap, 100));
        //System.out.println(badConcurrentMap.getNames());
    }

    private String getName(){
        Collections.shuffle(names);
        return names.get(0);
    }


}
