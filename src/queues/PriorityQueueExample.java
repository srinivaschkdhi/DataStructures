package queues;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {

        Queue<Integer> priorityQueueDefOrd = new PriorityQueue<>();
        for (int i = 0; i <= 10; i++) {
            priorityQueueDefOrd.add(i);
        }
        priorityQueueDefOrd.forEach(System.out::println);
        for (int i = 0; i <= 10; i++) {
            Integer poll = priorityQueueDefOrd.poll();
            System.out.println(poll);
        }


        Queue<Integer> priorityQueueDesc = new PriorityQueue<>();
        for (int i = 0; i <= 10; i++) {
            priorityQueueDesc.add(i);
        }
        priorityQueueDesc.forEach(System.out::println);
        for (int i = 0; i <= 10; i++) {
            Integer poll = priorityQueueDesc.poll();
            System.out.println(poll);
        }



        Comparator<String> compareStringLen = Comparator.comparing(String::length);
        Queue<String> stringQueueLen = new PriorityQueue<>(compareStringLen);
        stringQueueLen.add("abc");
        stringQueueLen.add("ab");
        stringQueueLen.add("a");
        for (int i = 1; i <= 3; i++) {
            String remove = stringQueueLen.remove();
            System.out.println(remove);
        }


        Queue<String> stringQueueLenDesc = new PriorityQueue<>(compareStringLen.reversed());
        stringQueueLenDesc.add("abc");
        stringQueueLenDesc.add("ab");
        stringQueueLenDesc.add("a");
        for (int i = 1; i <= 3; i++) {
            String remove = stringQueueLenDesc.remove();
            System.out.println(remove);
        }




    }
}
