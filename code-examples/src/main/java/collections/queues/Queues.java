package collections.queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queues {
    Deque<String> deque=new ArrayDeque<>();
    Queue<String> queue=new PriorityQueue<>();

    public static void main(String[] args) {
        Queues queues = new Queues();
        queues.arrayDeque();
        queues.arrayQueue();
    }

    public void arrayDeque(){
        deque.addLast("One");
        deque.addFirst("Two");


        System.out.println(deque);
    }

    public void arrayQueue(){
        queue.add("One");
        queue.add("Two");

        System.out.println(queue);

    }



}
