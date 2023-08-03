package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/uncrossed-lines/
public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
//        return recursive(nums1, nums2, 0, 0);

//        int[][] memo = new int[nums1.length][nums2.length];
//        for (int[] row : memo)
//            Arrays.fill(row, -1);
//        return topDown(nums1, nums2, 0, 0, memo);

        return bottomUp(nums1, nums2);
    }

    private int bottomUp(int[] nums1, int[] nums2) {
        int[][] memo = new int[nums1.length + 1][nums2.length + 1];
        for (int row = 0; row < memo.length; row++)
            memo[row][0] = 0;
        for (int column = 0; column < memo[0].length; column++)
            memo[0][column] = 0;

        for (int row = 1; row < memo.length; row++) {
            for (int column = 1; column < memo[0].length; column++) {
                if (nums1[row - 1] == nums2[column - 1])
                    memo[row][column] = 1 + memo[row - 1][column - 1];
                else
                    memo[row][column] = Math.max(memo[row - 1][column], memo[row][column - 1]);
            }
        }
        return memo[nums1.length][nums2.length];
    }

    private int topDown(int[] nums1, int[] nums2, int index1, int index2, int[][] memo) {
        if (index1 >= nums1.length || index2 >= nums2.length) {
            return 0;
        }

        if (memo[index1][index2] != -1)
            return memo[index1][index2];

        if (nums1[index1] == nums2[index2]) {
            memo[index1][index2] = 1 + topDown(nums1, nums2, index1 + 1, index2 + 1, memo);
            return memo[index1][index2];
        }

        memo[index1][index2] = Math.max(topDown(nums1, nums2, index1, index2 + 1, memo),
                topDown(nums1, nums2, index1 + 1, index2, memo));
        return memo[index1][index2];
    }

    private int recursive(int[] nums1, int[] nums2, int index1, int index2) {
        if (index1 >= nums1.length || index2 >= nums2.length) {
            return 0;
        }

        if (nums1[index1] == nums2[index2])
            return 1 + recursive(nums1, nums2, index1 + 1, index2 + 1);

        return Math.max(recursive(nums1, nums2, index1, index2 + 1),
                recursive(nums1, nums2, index1 + 1, index2));
    }
}
