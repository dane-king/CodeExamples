package lambdas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

public class Compose {
    private Function<Integer, Integer> multiplyByItself= value->value*value;
    private Function<Integer, Integer> addByItself= value->value+value;
    //processes from right to left, multiple
    private Function<Integer, Integer> multiplyThenAdd = addByItself.compose(multiplyByItself);

    private Function<String, BigDecimal> convertToNum= x->new BigDecimal(x);
    private Function<BigDecimal,String> addDollar=x->"$" + x.setScale(2, RoundingMode.CEILING);
    private Function<String,String> convertToCurrency=addDollar.compose(convertToNum);

    //Need to assign the method reference to get at the apply etc.
    private Function<Integer, Integer> add3=ComposeObjUtil::add3;
    private Function<Integer, Integer> add2=ComposeObjUtil::add2;
    private Function<Integer, Integer> multiply2=ComposeObjUtil::multiply2;

    public String convertToCurrencyAndThen(String num){
        return convertToNum.andThen(addDollar).apply(num);
    }

    public String convertToCurrencyCompose(String num){
        return convertToCurrency.apply(num);
    }

    public int multiplyAndThenAdd(int num){
        return multiplyByItself.andThen(addByItself).apply(num);
    }

    public int multipleAddCompose(int num){
        return multiplyThenAdd.apply(num);
    }

    public int add2ThenMultiply2ThenAdd3(int num){
        return add2.andThen(multiply2).andThen(add3).apply(num);
    }

}
