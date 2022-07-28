package prefixSum;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contiguous-array/
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> countIndexMap = new HashMap<>();
        countIndexMap.put(0, -1);

        int maxLength = 0, count = 0;
        for (int index = 0; index < nums.length; index++) {
            count += nums[index] == 1 ? 1 : -1;

            if (countIndexMap.containsKey(count)) {
                maxLength = Math.max(maxLength, index - countIndexMap.get(count));
            } else {
                countIndexMap.put(count, index);
            }
        }
        return maxLength;
    }
}
