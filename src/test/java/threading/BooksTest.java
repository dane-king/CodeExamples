package threading;

import org.cactoos.Func;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.llorllale.cactoos.matchers.RunsInThreads;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;

@RunWith(MockitoJUnitRunner.class)
public class BooksTest {

    @Before
    public void setUp() {

    }

    @Test
    public void addsAndRetrieves() throws ExecutionException, InterruptedException {
        Books books = new Books();
        int threads = 10;
        ExecutorService service = Executors.newFixedThreadPool(threads);
        Collection<Future<Integer>> futures =
                new ArrayList<>(threads);
        for (int t = 0; t < threads; ++t) {
            final String title = String.format("Book #%d", t);
            futures.add(service.submit(() -> books.add(title)));
        }
        Set<Integer> ids = new HashSet<>();
        for (Future<Integer> f : futures) {
            ids.add(f.get());
        }
        assertThat(ids.size(), equalTo(threads));
    }

    @Test
    @Ignore //just to show that threads are in parallel, sometimes fails
    public void addsAndRetrievesInParallel() throws ExecutionException, InterruptedException {
        Books books = new Books();
        int threads = 1000;
        ExecutorService service = Executors.newFixedThreadPool(threads);
        AtomicBoolean running = new AtomicBoolean();
        AtomicInteger overlaps = new AtomicInteger();

        Collection<Future<Integer>> futures = IntStream
                .rangeClosed(1,threads)
                .mapToObj(c->{
                    final String title = String.format("Book #%d", c);
                    return service.submit(
                            () -> {
                                if (running.get()) {
                                    overlaps.incrementAndGet();
                                }
                                running.set(true);
                                int id = books.add(title);
                                running.set(false);
                                return id;
                            }
                    );
                })
                .collect(Collectors.toList());


//        for (int t = 0; t < threads; ++t) {
//            final String title = String.format("Book #%d", t);
//            futures.add(
//                    service.submit(
//                            () -> {
//                                if (running.get()) {
//                                    overlaps.incrementAndGet();
//                                }
//                                running.set(true);
//                                int id = books.add(title);
//                                running.set(false);
//                                return id;
//                            }
//                    )
//            );
//        }
        assertThat(overlaps.get(), greaterThan(0)); //if not in pa
        //assertThat(overlaps.get(), equalTo(0));
    }

    @Test
    public void addAndRetrieveCactoos() {
        Books books = new Books();
        assertThat(t ->{
            String title = String.format("Book #%d", t.getAndIncrement());
            int id = books.add(title);
            return Objects.equals(books.title(id), title);
        }, new RunsInThreads<>(new AtomicInteger(), 10));
    }

    private Function<Books, Func<AtomicInteger, Boolean>> func= books-> t ->{
        String title = String.format("Book #%d", t.getAndIncrement());
        int id = books.add(title);
        return Objects.equals(books.title(id), title);
    };

    @Test
    public void addsAndRetrievesCountDownLatch() throws ExecutionException, InterruptedException {
        Books books = new Books();
        int threads = 10;
        ExecutorService service = Executors.newFixedThreadPool(threads);
        CountDownLatch latch = new CountDownLatch(1);
        AtomicBoolean running = new AtomicBoolean();
        AtomicInteger overlaps = new AtomicInteger();


        Collection<Future<Integer>> futures = IntStream
                .rangeClosed(1, threads)
                .parallel()
                .mapToObj(c -> {
                    final String title = String.format("Book #%d", c);
                    Future<Integer> submit = service.submit(
                            () -> {
                                latch.await();
                                if (running.get()) {
                                    overlaps.incrementAndGet();
                                }
                                running.set(true);
                                int id = books.add(title);
                                running.set(false);
                                return id;
                            }
                    );
                    return submit;
                })
                .collect(Collectors.toList());
        latch.countDown();
        Set<Integer> ids = new HashSet<>();
        for (Future<Integer> f : futures) {
            ids.add(f.get());
        }
        assertThat(books.map.size(),equalTo(threads));

    }
}
