package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public int rob(int[] nums) {
//        return recursive(nums, 0);
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
//        return topDownDp(nums, 0, memo);
        return bottomUpDp(nums);
    }

    private int bottomUpDp(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);

        for (int index = 2; index < memo.length; index++) {
            memo[index] = Math.max(nums[index] + memo[index - 2], memo[index - 1]);
        }
        return memo[memo.length - 1];
    }

    private int topDownDp(int[] nums, int index, int[] memo) {
        if (index >= nums.length)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        int moneyOnTakingThis = nums[index] + topDownDp(nums, index + 2, memo);
        int moneyOnLeavingThis = topDownDp(nums, index + 1, memo);

        memo[index] = Math.max(moneyOnTakingThis, moneyOnLeavingThis);
        return memo[index];
    }

    private int recursive(int[] nums, int index) {
        if (index >= nums.length)
            return 0;

        int moneyOnTakingThis = nums[index] + recursive(nums, index + 2);
        int moneyOnLeavingThis = recursive(nums, index + 1);

        return Math.max(moneyOnTakingThis, moneyOnLeavingThis);
    }
}
