package patterns.java8patterns.behavior.delegate;

public class Sample {
    public static void main(String[] args) {

        CalculateNAV calculateNAV=new CalculateNAV(ticker->33.33);

        System.out.println(calculateNAV.compute("ORCL",100));

        CalculateNAV calculateNAV2=new CalculateNAV(StockFetcher::getStockPrice);

        System.out.println(calculateNAV2.compute("ORCL",100));
    }



}
