package topKElements;

import java.util.PriorityQueue;
// Important
// Given an unsorted array, find the k-th smallest element
public class KthSmallestNumber {
    public int find(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++)
            maxHeap.offer(arr[i]);

        for (int i = k; i < arr.length; i++)
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        return maxHeap.poll();
    }
}
