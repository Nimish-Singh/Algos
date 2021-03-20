package topKElements;

import java.util.Comparator;
import java.util.PriorityQueue;

// Given an unsorted array, find the k largest elements
public class KMaxElements {
    public int[] find(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        for (int i = 0; i < k; i++)
            minHeap.offer(arr[i]);

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }

        return minHeap.stream().mapToInt(Integer::intValue).toArray();
    }
}
