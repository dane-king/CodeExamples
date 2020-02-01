package lambdas;

import java.util.function.Function;

public class ComposeObjUtil {
    private static Function<Integer, Function<Integer, Integer>> addCurry = x-> y->x + y;
    private static Function<Integer, Integer> add2= addCurry.apply(2);


    public static int add2(int num){
        return add2.apply(num);
    }



    public static int multiply2(int num){
        return num * 2;
    }

    public static int add3(int num){
        return num + 3;
    }
}
