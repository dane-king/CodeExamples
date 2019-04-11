package lambdas;

import java.util.function.Consumer;

/**
 * Simpler when we have control over the run in sequence method
 */
public class ExceptionHandlingCreatingMethod {
    public void transfer(BankAccount a, BankAccount b, Integer amount) {
        FinancialTranser debit = () -> a.debit(amount);
        FinancialTranser credit = () -> a.credit(amount);
        Consumer<InsufficientFundsException> insufficientFundsHandler=(exception)->{
            //handle the exception
        };

        try {
            //async
            runInSequence2(debit, credit,insufficientFundsHandler);
            //simple
            runInSequence1(debit, credit);
        } catch (InsufficientFundsException e) {
            //handle cleanup here
        }

    }

    //maps the function to a type of Callable<InsufficientFundsException>
    //this is done by type inference
    @FunctionalInterface
    interface FinancialTranser {
        void transfer() throws InsufficientFundsException;
    }


    //simple calls
    public void runInSequence1(FinancialTranser debit, FinancialTranser credit) throws InsufficientFundsException {
        debit.transfer();
        credit.transfer();
    }

    //run async
    public void runInSequence2(FinancialTranser debit, FinancialTranser credit, Consumer<InsufficientFundsException> exceptionHandler) throws InsufficientFundsException {
        new Thread(() -> {
            try {
                debit.transfer();
                credit.transfer();
            } catch (InsufficientFundsException e) {
                exceptionHandler.accept(e);
            }
        }).start();
    }

}

