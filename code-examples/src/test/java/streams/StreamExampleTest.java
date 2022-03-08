package streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StreamExampleTest {

    private StreamExample example;

    @BeforeEach
    void setUp() {
        example = new StreamExample();
        example.getHolders().add(createListHolder("one", "abc", "def"));
        example.getHolders().add(createListHolder("two", "ghi", "jkl"));
        example.getHolders().add(createListHolder("three", "mno", "pqr"));
    }

    private StreamExample.ListHolder createListHolder(String one, String ...tickers) {
        StreamExample.ListHolder holder = new StreamExample.ListHolder(one);
        for (String ticker : tickers) {
            holder.getTickers().add(new StreamExample.Ticker(one, ticker));
        }
        return holder;
    }

    @Test
    void shouldFlattenListObjectsWithLists() {
        String flattenedList = flatten(example.getHolders());
        assertEquals( flattenedList, "abc,def,ghi,jkl,mno,pqr");
    }

    public String flatten(List<StreamExample.ListHolder> holders){
        return holders.stream()
                .map(StreamExample.ListHolder::getTickers)
                .flatMap(List::stream)
                .map(StreamExample.Ticker::getTicker)
                .collect(Collectors.joining(","));

    }
}