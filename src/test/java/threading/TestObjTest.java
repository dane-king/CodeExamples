package threading;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestObjTest {

    @Before
    public void setUp() {

    }

    @Test
    public void testConcurrent1() throws InterruptedException {
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

    @Test
    public void testConcurrent2() throws Exception {
        assertThreadsEqual(100,() -> TestObj.parseDate("12/1/2012"));
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


    private void assertThreadsEqual(final int threadCount, Callable<Date> task) throws Exception {
        List<Callable<Date>> tasks = Collections.nCopies(threadCount, task);
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<Date>> futures = executorService.invokeAll(tasks);
        List<Date> resultList = futures
                .stream()
                .map(getFuture())
                .collect(Collectors.toList());
        // Validate the IDs
        assertEquals(threadCount, futures.size());
        IntFunction<Date> dateIntFunction = (num) -> {
            try {
                return task.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        };
        List<Date> expectedList = IntStream.rangeClosed(1,threadCount)
                .mapToObj(dateIntFunction)
                .collect(Collectors.toList());
        Collections.sort(resultList);
        assertEquals(expectedList, resultList);
    }

    private Function<Future<Date>, Date> getFuture() {
        return dateFuture -> {
            try {
                return dateFuture.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        };

    }
}
