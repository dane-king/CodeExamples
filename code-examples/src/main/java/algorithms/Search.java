package algorithms;

import java.util.*;

public class Search {
    private final Map<String, List<String>> friends = new HashMap<>();


    public static void main(String[] args) {
        Search search = new Search();
        System.out.println("Result of search: " + search.breadthSearch());

    }

    public Search(){
        friends.put("you", List.of("alice", "bob", "claire"));
        friends.put("bob", List.of("anuj","peggy"));
        friends.put("alice", List.of("peggy"));
        friends.put("claire", List.of("tom","jonny"));
        friends.put("peggy", Collections.emptyList());
        friends.put("anuj", Collections.emptyList());
        friends.put("tom", Collections.emptyList());
        friends.put("jonny", Collections.emptyList());
    }

    public String breadthSearch(){
        List<String> searched= new ArrayList<>();
        Deque<String> queue = new LinkedList<>(friends.get("you"));

        while(!queue.isEmpty()){
            String person=queue.pop();
            if(searched.contains(person)){
               continue;
            }

            if(isSeller(person)){
                return person;
            }else{
                queue.addAll(friends.getOrDefault(person, Collections.emptyList()));
                searched.add(person);
            }
        }
        return "No One Found";
    }
    public boolean isSeller(String name){
        return name.endsWith("m");
    }


}

