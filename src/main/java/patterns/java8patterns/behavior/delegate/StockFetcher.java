package patterns.java8patterns.behavior.delegate;

import java.util.HashMap;
import java.util.Map;

public class StockFetcher {
    public static Map<String,Double> stockprices=new HashMap<>();
    static{
        stockprices.put("ORCL",35.55);
        stockprices.put("MSFT",62.10);
    }


    public static double getStockPrice(String ticker){
        System.out.println("faking fetch stock price");
        Double stockprice = stockprices.get(ticker);
        return stockprice ==null?0D:stockprice;
    }
}
