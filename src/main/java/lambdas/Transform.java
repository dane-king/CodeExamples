package lambdas;

@FunctionalInterface
public interface Transform<T,S> {
    T transform(S source);
}
