package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/combination-sum-iv/
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
//        return recursive(nums, target);

//        int[] memo = new int[target];
//        Arrays.fill(memo, -1);
//        return topDown(nums, target, memo);

        return bottomUp(nums, target);
    }

    private int bottomUp(int[] nums, int target) {
        int[] memo = new int[target + 1];
        memo[0] = 1;

        for (int incrementalTarget = 1; incrementalTarget <= target; incrementalTarget++) {
            for (int num : nums) {
                if (incrementalTarget - num >= 0)
                    memo[incrementalTarget] += memo[incrementalTarget - num];
            }
        }

        return memo[target];
    }

    private int topDown(int[] nums, int target, int[] memo) {
        if (target == 0)
            return 1;

        if (target < 0)
            return 0;

        if (memo[target - 1] != -1)
            return memo[target - 1];

        int answer = 0;
        for (int num : nums)
            answer += topDown(nums, target - num, memo);
        memo[target - 1] = answer;
        return memo[target - 1];
    }

    private int recursive(int[] nums, int target) {
        if (target == 0)
            return 1;

        if (target < 0)
            return 0;

        int answer = 0;
        for (int num : nums)
            answer += recursive(nums, target - num);
        return answer;
    }
}
