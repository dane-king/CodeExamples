package lambdas;

public class BankAccount {

    public void credit(Integer amount) throws InsufficientFundsException {
        throw new InsufficientFundsException();
    }

    public void debit(Integer amount) throws InsufficientFundsException {
        throw new InsufficientFundsException();
    }
}
