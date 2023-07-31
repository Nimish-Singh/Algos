package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
//        return recursive(nums, -1, 0);

        int[][] memo = new int[nums.length][nums.length];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return topDown(nums, -1, 0, memo);

//        return bottomUp(nums);
    }

    private int bottomUp(int[] nums) {
        int[][] memo = new int[nums.length + 1][nums.length + 1];

        for (int currentIndex = nums.length - 1; currentIndex >= 0; currentIndex--) {

            for (int previousIndex = currentIndex - 1; previousIndex >= -1; previousIndex--) {
                int includeCurrent = 0;

                if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
                    includeCurrent = 1 + memo[currentIndex + 1][currentIndex + 1];

                int excludeCurrent = memo[currentIndex + 1][previousIndex + 1];

                memo[currentIndex][previousIndex + 1] = Math.max(includeCurrent, excludeCurrent);

            }
        }
        return memo[0][0];
    }

    private int topDown(int[] nums, int previousIndex, int currentIndex, int[][] memo) {
        if (currentIndex == nums.length) {
            return 0;
        }

        if (memo[previousIndex + 1][currentIndex] != -1)
            return memo[previousIndex + 1][currentIndex];

        int includeCurrent = 0;
        if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex]) {
            includeCurrent = 1 + topDown(nums, currentIndex, currentIndex + 1, memo);
        }

        int excludeCurrent = topDown(nums, previousIndex, currentIndex + 1, memo);

        int maxLength = Math.max(includeCurrent, excludeCurrent);
        memo[previousIndex + 1][currentIndex] = maxLength;

        return memo[previousIndex + 1][currentIndex];
    }

    private int recursive(int[] nums, int previousIndex, int currentIndex) {
        if (currentIndex == nums.length) {
            return 0;
        }

        int includeCurrent = 0;
        if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex]) {
            includeCurrent = 1 + recursive(nums, currentIndex, currentIndex + 1);
        }

        int excludeCurrent = recursive(nums, previousIndex, currentIndex + 1);

        return Math.max(includeCurrent, excludeCurrent);
    }
}
