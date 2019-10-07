package queues.javapredefinedqueues;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {10, 8, 1, 6, 4, 9, 2, 5, 3, 7};
        int k = 3;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        int i;
        for (i = 0; i < k; i++) {
            pQueue.add(arr[i]);
        }
        for (int j = i; j < arr.length; j++) {
            if (arr[j] > pQueue.peek()) {
                pQueue.poll();
                pQueue.add(arr[j]);
            }
        }
        System.out.println(pQueue.peek());
    }
}
