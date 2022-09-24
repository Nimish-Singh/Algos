package blind75.array;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberIndexMap = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            if (numberIndexMap.containsKey(target - nums[index])) {
                return new int[]{numberIndexMap.get(target - nums[index]), index};
            }
            numberIndexMap.put(nums[index], index);
        }
        return new int[]{};
    }
}
