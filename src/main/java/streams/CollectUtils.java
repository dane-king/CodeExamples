package streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectUtils<T> {
    public Integer getPartitionedList(List<Integer> list, Function<Integer,Integer> transform, Integer beginValue){
        return list
                .stream()
                .collect(Collectors.reducing(beginValue,transform,Integer::sum));

    }

    public String getCSV(List<String> names){
        return names
                .stream()
                .collect(Collectors.joining(","));
    }
    public String getQuotedCSV(List<String> names){
        return names
                .stream()
                .parallel()
                .collect(new MyCollector(","));
    }

    public Map<Boolean, List<Integer>> getPartitionedList(List<Integer> list, Predicate<Integer> predicate){
        return list
                .stream()
                .collect(Collectors.partitioningBy(predicate));

    }

    public Map<String, List<Integer>> getGroupedList(List<Integer> list, Function<Integer,String> groupingFn){
        return list
                .stream()
                .collect(Collectors.groupingBy(groupingFn));

    }

}
