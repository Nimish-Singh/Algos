package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-subarray/
public class MaxSubarray {
    public int maxSubArray(int[] nums) {
//        return kadaneNonOptimised(nums);

        return kadaneOptimised(nums);
    }

    private int kadaneOptimised(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int maxSum = Integer.MIN_VALUE, currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            if (currentSum > maxSum)
                maxSum = currentSum;

            if (currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }

    private int kadaneNonOptimised(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] sums = new int[nums.length];

        int sum = 0;
        for (int index = 0; index < nums.length; index++) {
            if (sum + nums[index] >= 0) {
                sum += nums[index];
                sums[index] = sum;
            }
            else {
                sum = 0;
                sums[index] = nums[index];
            }

        }
        return Arrays.stream(sums).max().getAsInt();
    }
}
