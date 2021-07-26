package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
public class MinOperationsToReduceToZero {
    public int minOperations(int[] nums, int x) {
        int arraySum = Arrays.stream(nums).sum();
        if (x > arraySum)
            return -1;

        int targetForMaxSum = arraySum - x;
        int maxLength = Integer.MIN_VALUE, windowStart = 0;

        int sum = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            sum += nums[windowEnd];

            while (sum > targetForMaxSum && windowStart < nums.length)
                sum -= nums[windowStart++];

            if (sum == targetForMaxSum)
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength == Integer.MIN_VALUE ? -1 : nums.length - maxLength;
    }
}
