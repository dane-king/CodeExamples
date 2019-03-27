package threading;

import org.junit.Ignore;
import org.junit.Test;
import org.llorllale.cactoos.matchers.RunsInThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

@Ignore
//wip
public class UniqueIdTest {


    static class UniqueIdGenerator {
        private final AtomicLong counter = new AtomicLong();

        public long nextId() {
            delay(2);
            return counter.incrementAndGet();

        }
    }

    private static void delay(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class BrokenUniqueIdGenerator {
        private long counter = 0;

        public long nextId() {
            delay(2);
            return ++counter;
        }


    }


    @Test
    public void shouldFail() {
        List<Long> numbers=new ArrayList<>();
        assertThat(t ->{
            long id =t.nextId();
            if(numbers.contains(id)){
                fail();
            }
            numbers.add(id);
            return true;
        }, new RunsInThreads<>(new UniqueIdGenerator(), 100));
    }

    @Test
    public void shouldPass() {
        List<Long> numbers=new ArrayList<>();
        assertThat(t ->{
            long id =t.nextId();
            if(numbers.contains(id)){
                fail();
            }
            numbers.add(id);
            return true;
        }, new RunsInThreads<>(new UniqueIdGenerator(), 100));
    }


}
