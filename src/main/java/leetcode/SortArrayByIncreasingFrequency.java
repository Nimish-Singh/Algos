package leetcode;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/sort-array-by-increasing-frequency/description/
public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        Comparator<Integer> comparator = (a, b) -> freq.get(a) != freq.get(b) ? freq.get(a) - freq.get(b) : b - a;

        List<Integer> list = Arrays.stream(nums).boxed().sorted(comparator).toList();

        return list.stream().mapToInt(x -> x).toArray();
    }
}
