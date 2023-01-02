package threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Futures {
    public static void main(String[] args) {
        try {
            new Futures().doIt();
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }

    }
    public static long factorial(int number) {
        long result = 1;
        for(int i=number;i>0;i--) {
            result *= i;
        }
        return result;
    }

    public void doIt() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> factorial(15))
                .thenApplyAsync(num-> {
                    long num1 = factorial(10);
                    System.out.println("Number is " + num + " and " + num1);
                    return num;
                });
//        while (!completableFuture.isDone()) {
//            System.out.println("CompletableFuture is not finished yet...");
//        }
        long result = completableFuture.get(10, TimeUnit.SECONDS);
    }

}
