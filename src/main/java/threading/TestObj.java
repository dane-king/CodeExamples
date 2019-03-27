package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class TestObj implements Runnable {
    private final ExecutorService executorService ;
    private Object ready=new Object();
    private volatile boolean cancelled;
    private AtomicInteger num;

    public TestObj(ExecutorService executorService) {
        this.executorService = executorService;
    }


    public void start() {
        //nop
        
    }

    public void stop() {
        //nop
    }

    public void cancel(){
        cancelled=true;
        synchronized (ready){
            ready.notifyAll();
        }
    }

    public void incr() {
        synchronized (ready){
            ready.notifyAll();
        }

    }

    public String get() {
        return null;

    }

    @Override
    public void run() {
        try {
            synchronized (ready) {
                while (!cancelled) {
                    ready.wait();
                    num.incrementAndGet();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace(); // bad practise generally, but good enough for this example
        }

    }
}
