package lambdas;

public class InsufficientRuntimeException extends RuntimeException{
    public InsufficientRuntimeException(InsufficientFundsException cause) {
        super(cause);
    }
}
