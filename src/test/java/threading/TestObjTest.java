package threading;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class TestObjTest {

    @Before
    public void setUp() {

    }

    @Test
    public void shouldPass() throws InterruptedException {
        List<Callable> tasks= Arrays.asList(
                () -> TestObj.parseDate("10/3/2011"),
                ()->TestObj.parseDate("3/13/2004"),
                ()->TestObj.parseDate("7/24/2017"),
                ()->TestObj.parseDate("1/3/2019"),
                ()->TestObj.parseDate("7/1/2001"),
                ()->TestObj.parseDate("11/30/1992"),
                ()->TestObj.parseDate("9/23/2002"),
                ()->TestObj.parseDate("2/5/1997"),
                ()->TestObj.parseDate("12/11/1999"),
                ()->TestObj.parseDate("12/5/1997"),
                ()->TestObj.parseDate("4/5/1995")
        );
        assertConcurrent("Test me", tasks, 100);

    }

    public static void assertConcurrent(final String message, final List<? extends Callable> runnables, final int maxTimeoutSeconds) throws InterruptedException {
        final int numThreads = runnables.size();
        final List<Throwable> exceptions = Collections.synchronizedList(new ArrayList<>());
        final ExecutorService threadPool = Executors.newFixedThreadPool(numThreads);
        try {
            final CountDownLatch allExecutorThreadsReady = new CountDownLatch(numThreads);
            final CountDownLatch afterInitBlocker = new CountDownLatch(1);
            final CountDownLatch allDone = new CountDownLatch(numThreads);
            for (final Callable submittedTestRunnable : runnables) {
                threadPool.submit(() -> {
                    allExecutorThreadsReady.countDown();
                    try {
                        afterInitBlocker.await();
                        submittedTestRunnable.call();
                    } catch (final Throwable e) {
                        exceptions.add(e);
                    } finally {
                        allDone.countDown();
                    }
                });
            }
            // wait until all threads are ready
            assertTrue("Timeout initializing threads! Perform long lasting initializations before passing runnables to assertConcurrent", allExecutorThreadsReady.await(runnables.size() * 10, TimeUnit.MILLISECONDS));
            // start all test runners
            afterInitBlocker.countDown();
            assertTrue(message +" timeout! More than" + maxTimeoutSeconds + "seconds", allDone.await(maxTimeoutSeconds, TimeUnit.SECONDS));
        } finally {
            threadPool.shutdownNow();
        }

        //assert no exceptions, if client is catching exceptions might just see stack trace
        assertTrue(message + "failed with exception(s)" + exceptions, exceptions.isEmpty());
    }
}
