package leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/description/
public class SmallestMissingAfterOperations {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> modCounts = new HashMap<>(value);
        boolean[] elementPossible = new boolean[nums.length];
        for (int num : nums) {
            int mod = num % value;
            if (mod < 0) {
                // for a negative number
                mod += value;
            }
            modCounts.put(mod, modCounts.getOrDefault(mod, 0) + 1);
        }

        for (Integer mod : modCounts.keySet()) {
            for (int count = 0; count < modCounts.get(mod); count++) {
                int index = value * count + mod;
                if (index < elementPossible.length)
                    elementPossible[index] = true;
            }
        }

        for (int index = 0; index < elementPossible.length; index++) {
            if (!elementPossible[index])
                return index;
        }
        // Max possible answer is nums.length
        return nums.length;
    }
}
