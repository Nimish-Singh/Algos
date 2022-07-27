package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/continuous-subarray-sum/
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderIndexMap = new HashMap<>();

        int runningSum = 0;
        for (int index = 0; index < nums.length; index++) {
            runningSum += nums[index];
            runningSum %= k;

            if (runningSum == 0 && index > 0) {
                return true;
            }

            Integer previousIndex = remainderIndexMap.get(runningSum);
            if (previousIndex == null) {
                remainderIndexMap.put(runningSum, index);
                continue;
            }
            if (index - previousIndex > 1) {
                return true;
            }
        }
        return false;
    }
}
