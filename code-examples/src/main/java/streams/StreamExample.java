package streams;

import java.util.ArrayList;
import java.util.List;

public class StreamExample {
    private final List<ListHolder> holders=new ArrayList<>();

    public List<ListHolder> getHolders() {
        return holders;
    }


    static class ListHolder {
        private final String name;

        public ListHolder(String name) {
            this.name = name;
        }

        private final List<Ticker> tickers= new ArrayList<>();


        public List<Ticker> getTickers() {
            return tickers;
        }

        public String getName() {
            return name;
        }
    }

    static class Ticker {
        private final String name;
        private final String ticker;

        Ticker(String name, String ticker) {
            this.name = name;
            this.ticker = ticker;
        }

        public String getName() {
            return name;
        }

        public String getTicker() {
            return ticker;
        }
    }
}
