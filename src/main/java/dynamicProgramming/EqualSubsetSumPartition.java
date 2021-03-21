package dynamicProgramming;

import java.util.Arrays;

// Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both subsets is equal
public class EqualSubsetSumPartition {
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).reduce(Integer::sum).getAsInt();
        if (totalSum % 2 == 1)
            return false;

//        return recursive(nums, totalSum / 2, 0);

        Boolean[][] memo = new Boolean[nums.length][totalSum / 2 + 1];
        for (Boolean[] row : memo) Arrays.fill(row, null);
        return topDown(memo, nums, totalSum / 2, 0);

//        return bottomUp(nums, totalSum / 2);
    }

    private boolean bottomUp(int[] nums, int sum) {
        Boolean[][] memo = new Boolean[nums.length][sum + 1];

        for (int index = 0; index < memo.length; index++)
            memo[index][0] = true;

        for (int runningSum = 1; runningSum <= sum; runningSum++)
            memo[0][runningSum] = nums[0] == runningSum;

        for (int index = 1; index < nums.length; index++) {
            for (int runningSum = 1; runningSum <= sum; runningSum++) {
                if (memo[index - 1][runningSum])
                    memo[index][runningSum] = true;
                else
                    memo[index][runningSum] = memo[index - 1][runningSum - nums[index]];
            }
        }
        return memo[nums.length - 1][sum];
    }

    private boolean topDown(Boolean[][] memo, int[] nums, int sum, int index) {
        if (sum == 0)
            return true;

        if (nums.length == 0 || index >= nums.length)
            return false;

        if (memo[index][sum] == null) {
            if (nums[index] <= sum)
                if (topDown(memo, nums, sum - nums[index], index + 1)) {
                    memo[index][sum] = true;
                    return true;
                }
            memo[index][sum] = topDown(memo, nums, sum, index + 1);
        }

        return memo[index][sum];
    }

    private boolean recursive(int[] nums, int sum, int index) {
        if (sum == 0)
            return true;

        if (nums.length == 0 || index >= nums.length)
            return false;

        if (nums[index] <= sum)
            if (recursive(nums, sum - nums[index], index + 1))
                return true;

        return recursive(nums, sum, index + 1);
    }
}
