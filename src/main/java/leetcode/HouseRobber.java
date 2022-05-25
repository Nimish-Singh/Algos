package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

//        return recursiveHelper(nums, nums.length - 1);

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return topDownHelper(nums, nums.length - 1, memo);

//        return bottomUpHelper(nums);
    }

    private int bottomUpHelper(int[] nums) {
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];

        for (int index = 1; index < nums.length; index++) {
            int profitWhenRobbingThisHouse = memo[index - 1] + nums[index];
            int profitWhenNotRobbingThisHouse = memo[index];
            memo[index + 1] = Math.max(profitWhenRobbingThisHouse, profitWhenNotRobbingThisHouse);
        }
        return memo[nums.length];
    }

    private int topDownHelper(int[] nums, int index, int[] memo) {
        if (index < 0)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        int profitWhenRobbingThisHouse = nums[index] + topDownHelper(nums, index - 2, memo);
        int profitWhenNotRobbingThisHouse = topDownHelper(nums, index - 1, memo);
        memo[index] = Math.max(profitWhenRobbingThisHouse, profitWhenNotRobbingThisHouse);

        return memo[index];
    }

    private int recursiveHelper(int[] nums, int index) {
        if (index < 0)
            return 0;

        int profitWhenRobbingThisHouse = nums[index] + recursiveHelper(nums, index - 2);
        int profitWhenNotRobbingThisHouse = recursiveHelper(nums, index - 1);

        return Math.max(profitWhenRobbingThisHouse, profitWhenNotRobbingThisHouse);
    }
}
