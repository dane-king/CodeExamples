package lambdas;

/**
 * Example of wrapping lambdas to translate be able to handle exceptions
 */
public class ExceptionHandlingCallingMethod {
    public void transfer(BankAccount a, BankAccount b, Integer amount) {
        Runnable debit = unchecked(() -> a.debit(amount));
        Runnable credit = unchecked(() -> a.credit(amount));

        try {
            runInSequence(debit, credit);
        } catch (InsufficientRuntimeException e) {
           //handle cleanup here
        }

    }

    //transforms Checked exception to Runnable, now type can be Runnable instead of
    //Callable<InsufficientFundsException>
    static Runnable unchecked(Callable<InsufficientFundsException> function) {
        return () ->  {
            try{
                function.call();
            } catch (InsufficientFundsException e) {
                throw new InsufficientRuntimeException(e);
            }
        };
    }

    //maps the function to a type of Callable<InsufficientFundsException>
    //this is done by type inference
    @FunctionalInterface
    interface Callable<E extends Exception> {
        void call() throws E;
    }


    //simulates a outside call don't have access
    static void runInSequence(Runnable debit, Runnable credit) {
        new Thread(()->{
            debit.run();
            credit.run();
        }).start();
    }

}

