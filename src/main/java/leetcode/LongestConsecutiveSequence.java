package leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Set<Integer> elements = new HashSet<>();

        for (int element: nums)
            elements.add(element);

        int maxLength = 0;
        for (int element: nums) {
            if (!elements.contains(element - 1)) {
                int nextElementToCheck = element + 1;
                while (elements.contains(nextElementToCheck))
                    nextElementToCheck++;
                maxLength = Math.max(maxLength, nextElementToCheck - element);
            }
        }
        return maxLength;
    }
}
