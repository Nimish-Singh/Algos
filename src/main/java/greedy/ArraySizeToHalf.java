package greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/reduce-array-size-to-the-half/
public class ArraySizeToHalf {
    public int minSetSize(int[] arr) {
//        return heapApproach(arr);
        return countingSortApproach(arr);
    }

    private int countingSortApproach(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int element : arr) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        int[] frequencyCounts = new int[arr.length + 1];

        for (int frequency : frequencyMap.values()) {
            frequencyCounts[frequency]++;
        }

        int setCount = 0, removedCount = 0;
        for (int index = frequencyCounts.length - 1; index >= 0;) {
            if (frequencyCounts[index] == 0) {
                index--;
                continue;
            }

            if (removedCount >= arr.length / 2) {
                return setCount;
            }

            removedCount += index;
            setCount++;
            frequencyCounts[index]--;
        }
        return setCount;
    }

    private int heapApproach(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int element : arr) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());

        int removedCount = 0, setCount = 0;
        while (!maxHeap.isEmpty()) {
            if (removedCount >= arr.length / 2) {
                return setCount;
            }
            removedCount += frequencyMap.get(maxHeap.poll());
            setCount++;
        }
        return setCount;
    }
}
