package threading;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BadConcurrentMap {
    private List<String> names=new CopyOnWriteArrayList<>();

    public void addUniqueString(String name){
        //System.out.println("Name:" + name + " " + "List is " + names );

        //put-if-absent is not thread safe
//        if(!names.contains(name)){
//            names.add(name);
//        }
        //use correct methods
        ((CopyOnWriteArrayList)names).addIfAbsent(name);
    }

    public List<String> getNames() {
        return names;
    }
}
