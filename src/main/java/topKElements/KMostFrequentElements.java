package topKElements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// Given an unsorted array, return k elements with the highest frequency
public class KMostFrequentElements {
    public List<Integer> find(int[] arr, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> frequencyMap.getOrDefault(a, 0)));

        List<Integer> distinctElements = new ArrayList<>(frequencyMap.keySet());
        for (int i = 0; i < k; i++)
            minHeap.offer(distinctElements.get(i));

        for (int i = k; i < distinctElements.size(); i++)
            if (distinctElements.get(i) > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(distinctElements.get(i));
            }

        return new ArrayList<>(minHeap);
    }
}
