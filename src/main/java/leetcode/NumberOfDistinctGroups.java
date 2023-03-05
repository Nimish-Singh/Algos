package leetcode;

import java.util.HashMap;
import java.util.Map;

// Given an array of integers, return the minimum number of groups that can be created from this array, each with
// size <= m
public class NumberOfDistinctGroups {
    public int minGroups(int[] nums, int m) {
        if (nums == null || m <= 0) {
            return 0;
        }

        Map<Integer, Integer> numberFrequencyMap = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            numberFrequencyMap.put(num, numberFrequencyMap.getOrDefault(num, 0) + 1);
            max = Math.max(max, numberFrequencyMap.get(num));
        }

        int remainingElementsAfterMakingMaxGroups = Math.max(0, nums.length - (max * (m - 1)));
        return max + (int) Math.ceil((double) remainingElementsAfterMakingMaxGroups / m);
    }
}
