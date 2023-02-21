package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
1. Find largest element in an infinite stream of numbers
   a. Extend your solution to find nth largest element instead
   b. Extend your solution to find nth largest element in last K numbers
   c. Discuss time and space complexity in all the cases
 */
public class LargestOfNumberStream {
    private final int N = 5;
    private final int N_LAST_NUMBERS = 5;

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(N);
    private List<Integer> lastNElements = new ArrayList<>();

    private int max;

    public LargestOfNumberStream() {
        for (int index = 0; index < N; index++) {
            minHeap.offer(Integer.MIN_VALUE);
        }
        max = Integer.MIN_VALUE;
    }

    public int getNthLargest() throws Exception {
        if (minHeap.peek() == null || minHeap.peek() == Integer.MIN_VALUE) {
            throw new Exception("Not enough elements");
        }
        return minHeap.peek();
    }

    public int getMax() {
        return max;
    }

    /*
    Example and approach
     [2 3 4 6 1 3 1 5 7 2 8]
     3rd largest in last 5
     [3 3 3 3 3 3 5]
     Store n elements in list and create minheap of k elements on demand
     Time: O(nlogk), Space: O(n)
     */
    public int getKthLargestInLastNNumbers(int k) throws Exception {
        if (lastNElements.size() < N_LAST_NUMBERS) {
            throw new Exception("Not enough elements");
        }

        PriorityQueue<Integer> minHeapK = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        for (int index = 0; index < k; index++) {
            minHeapK.offer(lastNElements.get(index));
        }

        for (int index = k; index < N_LAST_NUMBERS; index++) {
            if (lastNElements.get(index) > minHeapK.peek()) {
                minHeapK.poll();
                minHeapK.offer(lastNElements.get(index));
            }
        }
        return minHeapK.poll();
    }

    public int generateNum(int num) {
        if (num > max) {
            max = num;
        }

        // needed only to find n-th largest number
        if (num > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(num);
        }

        // needed only to find k-th largest in last n numbers
        if (lastNElements.size() < N_LAST_NUMBERS) {
            lastNElements.add(num);
        } else {
            lastNElements.remove(0);
            lastNElements.add(num);
        }
        return num;
    }
}
