package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description/
public class Conditional2DArray {
    public List<List<Integer>> findMatrix(int[] nums) {
//        return maxHeapApproach(nums);

        return elementCountApproach(nums);
    }

    // T=O(n) S=O(n)
    private List<List<Integer>> elementCountApproach(int[] nums) {
        int[] count = new int[nums.length + 1];

        List<List<Integer>> answer = new ArrayList<>();
        for (int num : nums) {
            count[num]++;

            if (answer.size() < count[num]) {
                answer.add(new ArrayList<>());
            }

            answer.get(count[num] - 1).add(num);
        }
        return answer;
    }

    // T=O(nlogn) S=O(n)
    private List<List<Integer>> maxHeapApproach(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        maxHeap.addAll(frequencyMap.keySet());

        Integer size = frequencyMap.get(maxHeap.peek());
        List<List<Integer>> answer = new ArrayList<>(size);

        for (int index = 0; index < size; index++) {
            answer.add(new ArrayList<>());
        }

        while (!maxHeap.isEmpty()) {
            Integer currentElem = maxHeap.poll();
            Integer currentFreq = frequencyMap.get(currentElem);
            for (int index = 0; index < currentFreq; index++) {
                answer.get(index).add(currentElem);
            }
        }

        return answer;
    }
}
