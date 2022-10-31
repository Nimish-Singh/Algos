package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber-ii/
public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] memo = new int[nums.length];

        Arrays.fill(memo, -1);
        // rob 0th house and consider n-2 as the last possibility
        int startingFromZero = helper(nums, 0, memo, nums.length - 2);

        Arrays.fill(memo, -1);
        // don't rob 0th house and consider n-1 as the last possibility
        int startingFromOne = helper(nums, 1, memo, nums.length - 1);

        return Math.max(startingFromZero, startingFromOne);
    }

    private int helper(int[] nums, int index, int[] memo, int high) {
        if (index > high)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        int whenRobbingThisHouse = nums[index] + helper(nums, index + 2, memo, high);
        int whenLeavingThisHouse = helper(nums, index + 1, memo, high);

        memo[index] = Math.max(whenRobbingThisHouse, whenLeavingThisHouse);
        return memo[index];
    }
}
