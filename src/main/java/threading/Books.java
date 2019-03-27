package threading;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Books {
    final Map<Integer,String> map=new ConcurrentHashMap();
    final AtomicInteger id = new AtomicInteger(0);

    int add(String title){
        Integer next=id.getAndIncrement();
        this.map.put(next,title);
        return next;
    }

    String title(int id){
        return this.map.get(id);
    }
}
