package predicate.validator;

public class Test {
    public static void main(String[] args) {
        String a = "test";
        String b = a;
        a = null;
        System.out.println("My vars are a:" + a + " and b:" + b + "and not equal" + a.equals(b));
    }
}
